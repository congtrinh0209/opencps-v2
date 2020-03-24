package org.opencps.usermgt.action.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.opencps.communication.model.ServerConfig;
import org.opencps.communication.service.ServerConfigLocalServiceUtil;
import org.opencps.usermgt.action.DVCQGSSOInterface;
import org.opencps.usermgt.model.Applicant;
import org.opencps.usermgt.service.ApplicantLocalServiceUtil;
import org.opencps.usermgt.service.util.DateTimeUtils;

/**
 * @author trungnt
 *
 */
public class DVCQGSSOActionImpl implements DVCQGSSOInterface {
	private Log _log = LogFactoryUtil.getLog(DVCQGSSOActionImpl.class);

	@Override
	public String getAuthURL(User user, long groupId, HttpServletRequest request, ServiceContext serviceContext,
			String state, String redirectURL) {

		List<ServerConfig> serverConfigs = ServerConfigLocalServiceUtil.getByProtocol("DVCQG-OPENID");

		if (serverConfigs != null && !serverConfigs.isEmpty()) {
			ServerConfig serverConfig = serverConfigs.get(0);
			try {
				JSONObject config = JSONFactoryUtil.createJSONObject(serverConfig.getConfigs());
				String auth_server = config.getString("auth_server");
				String auth_endpoint = config.getString("auth_endpoint");
				String clientid = config.getString("clientid");
				String callback_url = config.getString("callback_url");
				String scope = config.getString("scope");
				String acr_values = config.getString("acr_values");
				state = state + "@" + redirectURL;
				state = Base64.getEncoder().encodeToString(state.getBytes());
				String endpoint = auth_server + auth_endpoint + "?response_type=code" + "&client_id=" + clientid
						+ "&redirect_uri=" + callback_url + "&scope=" + scope + "&acr_values=" + acr_values + "&state="
						+ state;

				return endpoint;

			} catch (Exception e) {
				_log.error(e);
				return StringPool.BLANK;
			}

		}

		return StringPool.BLANK;
	}

	@Override
	public String checkAuth(User user, long groupId, HttpServletRequest request, ServiceContext serviceContext,
			int vnconnect, String currentURL) {

		List<ServerConfig> serverConfigs = ServerConfigLocalServiceUtil.getByProtocol("DVCQG-OPENID");
		if (serverConfigs != null && !serverConfigs.isEmpty()) {
			ServerConfig serverConfig = serverConfigs.get(0);

			HttpURLConnection conn = null;
			try {

				JSONObject config = JSONFactoryUtil.createJSONObject(serverConfig.getConfigs());
				String auth_server = config.getString("auth_server");
				String auth_endpoint = config.getString("auth_endpoint");
				String clientid = config.getString("clientid");
				String callback_url = config.getString("callback_url");
				String scope = config.getString("openid");
				String acr_values = config.getString("acr_values");
				String endpoint = auth_server + auth_endpoint + "?response_type=code" + "&client_id=" + clientid
						+ "&redirect_uri=" + callback_url + "&scope=" + scope + "&acr_values=" + acr_values + "&state="
						+ AuthTokenUtil.getToken(request);

				URL url = new URL(endpoint);

				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				conn.setDoOutput(true);

				conn.setRequestProperty("Accept", "text/html");
				conn.setRequestProperty("Content-Type", "text/html");
				conn.setInstanceFollowRedirects(true);
				HttpURLConnection.setFollowRedirects(true);
				conn.setReadTimeout(60 * 1000);
				conn.connect();

				try (BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader((conn.getInputStream())))) {

					String output = StringPool.BLANK;

					StringBuilder sb = new StringBuilder();

					while ((output = bufferedReader.readLine()) != null) {
						sb.append(output);
					}

					_log.info("response: " + sb.toString());

					// int responseCode = conn.getResponseCode();

					return sb.toString();

				}

			} catch (Exception e) {
				_log.error(e);
				return StringPool.BLANK;
			} finally {
				if (conn != null) {
					conn.disconnect();
				}
			}

		}
		return StringPool.BLANK;
	}

	@Override
	public JSONObject getUserInfo(User user, long groupId, HttpServletRequest request, ServiceContext serviceContext,
			String authToken, String state) {
		List<ServerConfig> serverConfigs = ServerConfigLocalServiceUtil.getByProtocol("DVCQG-OPENID");

		JSONObject result = JSONFactoryUtil.createJSONObject();

		if (serverConfigs != null && !serverConfigs.isEmpty()) {
			ServerConfig serverConfig = serverConfigs.get(0);

			JSONObject accessTokenInfo = getAccessToken(user, groupId, serviceContext, authToken, serverConfig);

			if (accessTokenInfo.length() > 0 && accessTokenInfo.has("access_token")) {
				String accessToken = accessTokenInfo.getString("access_token");
				state = "create";
				int LoaiTaiKhoan = 0;
				//String HoChieu = StringPool.BLANK;
				String SoCMND = StringPool.BLANK;
				String MaSoThue = StringPool.BLANK;
				String MaSoDoanhNghiep = StringPool.BLANK;
				String SoDinhDanh = StringPool.BLANK;
				String TechID = StringPool.BLANK;

				result = invokeUserInfo(user, groupId, serviceContext, accessToken, serverConfig);

				if (result == null || result.length() == 0) {
					result = JSONFactoryUtil.createJSONObject();
					state = StringPool.BLANK;
					result.put("userId", 0);
					result.put("statusCode", 500);
					result.put("state", state);

				} else {
					LoaiTaiKhoan = result.getInt("LoaiTaiKhoan");
					//HoChieu = result.getString("HoChieu");
					SoCMND = result.getString("SoCMND");
					MaSoThue = result.getString("MaSoThue");
					MaSoDoanhNghiep = result.getString("MaSoDoanhNghiep");
					SoDinhDanh = result.getString("SoDinhDanh");
					TechID = result.getString("TechID");

					Applicant applicant = ApplicantLocalServiceUtil.fetchByF_GID_MCN_MCPK(result.getLong("groupId"),
							_DEFAULT_CLASS_NAME, TechID);

					if (applicant != null) {
						state = "auth";
						result.put("userId", applicant.getMappingUserId());
						result.put("statusCode", 200);
						result.put("state", state);
					} else {
						if (LoaiTaiKhoan == 1) {
							applicant = ApplicantLocalServiceUtil.fetchByF_APLC_GID(groupId,
									Validator.isNotNull(SoCMND) ? SoCMND : SoDinhDanh);
							if (applicant != null) {
								state = "mapping";
								result.put("userId", 0);
								result.put("statusCode", 200);
								result.put("state", state);
							} else {
								state = "create";
								result.put("userId", 0);
								result.put("statusCode", 200);
								result.put("state", state);
							}
						} else {
							applicant = ApplicantLocalServiceUtil.fetchByF_APLC_GID(groupId,
									Validator.isNotNull(MaSoThue) ? MaSoThue : MaSoDoanhNghiep);

							if (applicant != null) {
								state = "mapping";
								result.put("userId", 0);
								result.put("statusCode", 200);
								result.put("state", state);
							} else {
								state = "create";
								result.put("userId", 0);
								result.put("statusCode", 200);
								result.put("state", state);
							}
						}

					}

				}

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("SSO_STATE", state);
				httpSession.setAttribute("ACCESS_TOKEN", accessToken);
			}
		}

		if ((result != null && result.has("loAs"))) {
			//luoc bo dl
			result.remove("loAs");
		}

		String encryptData = (result != null && result.length() > 0)
				? Base64.getEncoder().encodeToString(result.toJSONString().getBytes())
				: StringPool.BLANK;
		result.put("encryptData", encryptData);

		return result;
	}

	private JSONObject invokeUserInfo(User user, long groupId, ServiceContext serviceContext, String accessToken,
			ServerConfig serverConfig) {

		HttpURLConnection conn = null;
		try {

			JSONObject config = JSONFactoryUtil.createJSONObject(serverConfig.getConfigs());
			String auth_server = config.getString("auth_server");
			String userinfo_endpoint = config.getString("userinfo_endpoint");

			String endpoint = auth_server + userinfo_endpoint;

			URL url = new URL(endpoint);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setReadTimeout(60 * 1000);

			conn.setUseCaches(false);

			conn.connect();

			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())))) {

				String output = StringPool.BLANK;

				StringBuilder sb = new StringBuilder();

				while ((output = bufferedReader.readLine()) != null) {
					sb.append(output);
				}

				_log.info("response: " + sb.toString());

				int responseCode = conn.getResponseCode();

				if (responseCode == 200) {
					JSONObject result = JSONFactoryUtil.createJSONObject(sb.toString());
					result.put("groupId", config.get("groupId"));
					return result;
				} else {

					return JSONFactoryUtil.createJSONObject();
				}

			}

		} catch (Exception e) {
			_log.error(e);
			return JSONFactoryUtil.createJSONObject();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public boolean isValidAccessToken(String accessToken) {
		List<ServerConfig> serverConfigs = ServerConfigLocalServiceUtil.getByProtocol("DVCQG-OPENID");

		if (serverConfigs != null && !serverConfigs.isEmpty()) {
			ServerConfig serverConfig = serverConfigs.get(0);
			return isValidAccessToken(serverConfig, accessToken);
		}

		return false;
	}

	private boolean isValidAccessToken(ServerConfig serverConfig, String accessToken) {

		HttpURLConnection conn = null;
		try {

			JSONObject config = JSONFactoryUtil.createJSONObject(serverConfig.getConfigs());
			String auth_server = config.getString("auth_server");
			String validatetoken_endpoint = config.getString("validatetoken_endpoint");

			String endpoint = auth_server + validatetoken_endpoint;

			URL url = new URL(endpoint);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setUseCaches(false);
			conn.setReadTimeout(60 * 1000);
			StringBuffer params = new StringBuffer();
			params.append("token=" + accessToken);
			params.append("&state=0");
			byte[] postData = params.toString().getBytes("UTF-8");
			int postDataLength = postData.length;
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
			conn.connect();

			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())))) {

				String output = StringPool.BLANK;

				StringBuilder sb = new StringBuilder();

				while ((output = bufferedReader.readLine()) != null) {
					sb.append(output);
				}

				int responseCode = conn.getResponseCode();

				_log.info("response: " + sb.toString() + "|" + responseCode);

				if (responseCode == 200) {
					JSONObject object = JSONFactoryUtil.createJSONObject(sb.toString());

					String client_id = object.getString("client_id");
					long exp = object.getLong("exp");
					if (client_id.equals(config.getString("clientid")) && exp > System.currentTimeMillis() / 1000) {
						_log.info("------------------>>>>>>> accessToken " + accessToken + "| has expire");
						return true;
					}

					return false;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			_log.error(e);
			return false;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(c.getTimeInMillis());

		String test = "12345@abcde";

		String state = test.substring(0, test.lastIndexOf("@"));

		String redirect = test.substring(test.lastIndexOf("@") + 1, test.length());

		System.out.println(state);

		System.out.println(redirect);
	}

	private JSONObject getAccessToken(User user, long groupId, ServiceContext serviceContext, String authToken,
			ServerConfig serverConfig) {

		HttpURLConnection conn = null;
		try {

			JSONObject config = JSONFactoryUtil.createJSONObject(serverConfig.getConfigs());
			String auth_server = config.getString("auth_server");
			String accesstoken_endpoint = config.getString("accesstoken_endpoint");
			String clientid = config.getString("clientid");
			String callback_url = config.getString("callback_url");
			String client_secret = config.getString("client_secret");

			StringBuffer params = new StringBuffer();
			params.append("grant_type=authorization_code");
			params.append("&code=" + authToken);
			params.append("&redirect_uri=" + callback_url);
			params.append("&client_id=" + clientid);
			params.append("&client_secret=" + client_secret);

			String endpoint = auth_server + accesstoken_endpoint;
			
			_log.debug("endpoint --->>> " + endpoint);

			URL url = new URL(endpoint);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setReadTimeout(60 * 1000);

			conn.setUseCaches(false);
			byte[] postData = params.toString().getBytes("UTF-8");
			int postDataLength = postData.length;
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}

			conn.connect();

			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())))) {

				String output = StringPool.BLANK;

				StringBuilder sb = new StringBuilder();

				while ((output = bufferedReader.readLine()) != null) {
					sb.append(output);
				}

				_log.info("response: " + sb.toString());

				int responseCode = conn.getResponseCode();

				if (responseCode == 200) {
					return JSONFactoryUtil.createJSONObject(sb.toString());
				} else {
					return JSONFactoryUtil.createJSONObject();
				}

			}

		} catch (Exception e) {
			_log.error(e);
			return JSONFactoryUtil.createJSONObject();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	private JSONObject createErrorMessage(String error, int statusCode) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("statusCoode", statusCode);
		result.put("message", error);
		return result;
	}

	@Override
	public JSONObject doAuth(User user, HttpServletRequest request, HttpServletResponse response,
			ServiceContext serviceContext, String userInfo) {

		try {

			JSONObject userInfoObject = JSONFactoryUtil.createJSONObject(userInfo);

			int LoaiTaiKhoan = userInfoObject.getInt("LoaiTaiKhoan");
			//String HoChieu = userInfoObject.getString("HoChieu");
			String SoCMND = userInfoObject.getString("SoCMND");
			String MaSoThue = userInfoObject.getString("MaSoThue");
			//int GioiTinh = userInfoObject.getInt("GioiTinh");
			String DiaChi = userInfoObject.getString("DiaChi");
			String SoDienThoai = userInfoObject.getString("SoDienThoai");
			String ThuDienTu = userInfoObject.getString("ThuDienTu");
			String HoVaTen = userInfoObject.getString("HoVaTen");
			//String sub = userInfoObject.getString("sub");
			String TenDoanhNghiep = userInfoObject.getString("TenDoanhNghiep");
			String MaSoDoanhNghiep = userInfoObject.getString("MaSoDoanhNghiep");
			String SoDinhDanh = userInfoObject.getString("SoDinhDanh");

			String TechID = userInfoObject.getString("TechID");

			long groupId = userInfoObject.getLong("groupId");

			String state = userInfoObject.getString("state");

			if (Validator.isNull(TechID)) {
				return createErrorMessage("not found tecihd", 404);
			}

			if (LoaiTaiKhoan == 1 && Validator.isNull(SoCMND) && Validator.isNull(SoDinhDanh)) {
				return createErrorMessage("not found SoCMND", 404);
			}

			if (LoaiTaiKhoan == 2 && Validator.isNull(MaSoThue) && Validator.isNull(MaSoDoanhNghiep)) {
				return createErrorMessage("not found MaSoThue", 404);
			}

			Applicant applicant = null;

			JSONObject result = JSONFactoryUtil.createJSONObject();

			_log.info(">>>>>>>>>>>>>>>>>>>>>>>> userInfoObject " + userInfoObject.toJSONString());

			applicant = ApplicantLocalServiceUtil.fetchByF_GID_MCN_MCPK(groupId, _DEFAULT_CLASS_NAME, TechID);

			String accessToken = StringPool.BLANK;

			//Enumeration<String> enumeration = request.getSession().getAttributeNames();

			//List<String> values = Collections.list(enumeration);

			//for (String value : values) {
			//	_log.info("========================== > session.getAttributeNames() " + value);
			//}

			if (request.getSession().getAttribute("ACCESS_TOKEN") != null) {
				accessToken = request.getSession().getAttribute("ACCESS_TOKEN").toString();
			}

			long mappingUserId = 0;

			//_log.info("------------>>> accessToken: " + accessToken + "|state " + state);

			if (state.equalsIgnoreCase("auth") && applicant != null) {

				mappingUserId = applicant.getMappingUserId();

				User mappingUser = UserLocalServiceUtil.fetchUser(mappingUserId);

				if (mappingUser == null) {
					return createErrorMessage("account not exist with userId = " + mappingUserId, 500);
				}

				if (mappingUser.getStatus() != WorkflowConstants.STATUS_APPROVED) {
					return createErrorMessage("the account has been locked", 401);
				}

				HttpSession session = request.getSession();
				session = renewSession(request, session);
				session.setAttribute("_GROUP_ID", groupId);
				session.setAttribute("_MAPPING_CLASS_NAME", applicant.getMappingClassName());
				session.setAttribute("_MAPPING_CLASS_PK", applicant.getMappingClassPK());
				session.setAttribute("_ACCESS_TOKEN", accessToken);

			} else if (state.equalsIgnoreCase("mapping")) {
				mappingUserId = user.getUserId();
				applicant = ApplicantLocalServiceUtil.fetchByMappingID(mappingUserId);
				if (applicant == null) {
					return createErrorMessage("not found applicant with userId = " + mappingUserId, 404);
				}

				applicant = ApplicantLocalServiceUtil.updateApplication(serviceContext, groupId,
						applicant.getApplicantId(), _DEFAULT_CLASS_NAME, TechID);

				HttpSession session = request.getSession();
				session = renewSession(request, session);
				session = renewSession(request, session);
				session.setAttribute("_GROUP_ID", groupId);
				session.setAttribute("_MAPPING_CLASS_NAME", applicant.getMappingClassName());
				session.setAttribute("_MAPPING_CLASS_PK", applicant.getMappingClassPK());
				session.setAttribute("_ACCESS_TOKEN", accessToken);
			} else if (state.equalsIgnoreCase("create")) {
				// ca nhan
				if (LoaiTaiKhoan == 1) {

					if (Validator.isNull(SoCMND) && Validator.isNull(SoDinhDanh)) {
						return createErrorMessage("Unknown SoCMND, SoDinhDanh", 404);
					}
					applicant = ApplicantLocalServiceUtil.fetchByF_APLC_GID(groupId,
							Validator.isNotNull(SoCMND) ? SoCMND : SoDinhDanh);

					if (applicant == null) {
						applicant = ApplicantLocalServiceUtil.fetchByEmail(ThuDienTu);
					}
				}
				// doanh nghiep
				else if (LoaiTaiKhoan == 2) {
					if (Validator.isNull(MaSoThue) && Validator.isNull(MaSoDoanhNghiep)) {
						return createErrorMessage("Unknown MaSoThue, MaSoDoanhNghiep", 404);
					}
					applicant = ApplicantLocalServiceUtil.fetchByF_APLC_GID(groupId,
							Validator.isNotNull(MaSoThue) ? MaSoThue : MaSoDoanhNghiep);
					if (applicant == null) {
						applicant = ApplicantLocalServiceUtil.fetchByEmail(ThuDienTu);
					}
				} else {
					return createErrorMessage("Unknown LoaiTaiKhoan", 404);
				}

				// create
				if (Validator.isNull(ThuDienTu)) {
					//return createErrorMessage("Unknown ThuDienTu", 404);
					ThuDienTu = TechID + "@dvcqg.gov.vn";
				}

				applicant = ApplicantLocalServiceUtil.updateApplication(serviceContext, groupId, 0L,
						LoaiTaiKhoan == 1 ? HoVaTen : TenDoanhNghiep, LoaiTaiKhoan == 1 ? "citizen" : "business",
						LoaiTaiKhoan == 1 ? (Validator.isNotNull(SoCMND) ? SoCMND : SoDinhDanh)
								: (Validator.isNotNull(MaSoThue) ? MaSoThue : MaSoDoanhNghiep),
						DateTimeUtils.dateToString(new Date(), DateTimeUtils._TYPEDATE), DiaChi, StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, SoDienThoai, ThuDienTu, StringPool.BLANK, TechID, true);

				applicant = ApplicantLocalServiceUtil.updateApplication(serviceContext, groupId,
						applicant.getApplicantId(), _DEFAULT_CLASS_NAME, TechID);

				mappingUserId = applicant.getMappingUserId();

				HttpSession session = request.getSession();
				session = renewSession(request, session);
				session = renewSession(request, session);
				session.setAttribute("_GROUP_ID", groupId);
				session.setAttribute("_MAPPING_CLASS_NAME", applicant.getMappingClassName());
				session.setAttribute("_MAPPING_CLASS_PK", applicant.getMappingClassPK());
				session.setAttribute("_ACCESS_TOKEN", accessToken);

			} else {
				result.put("statusCode", 500);
				result.put("message", "error");
				result.put("userId", 0);
				result.put("groupId", groupId);

				return result;
			}

			result.put("statusCode", 200);
			result.put("message", "success");
			result.put("userId", mappingUserId);
			result.put("groupId", groupId);
			result.put("email", applicant != null ? applicant.getContactEmail() : StringPool.BLANK);
			return result;
		} catch (Exception e) {
			_log.error(e);
			return createErrorMessage("An error while sso", 500);
		}
	}

	public HttpSession renewSession(HttpServletRequest request, HttpSession session) throws Exception {

		String[] protectedAttributeNames = new String[] { "CAS_LOGIN", "HTTPS_INITIAL", "LAST_PATH",
				"OPEN_ID_CONNECT_SESSION" };

		Map<String, Object> protectedAttributes = new HashMap<>();

		for (String protectedAttributeName : protectedAttributeNames) {
			Object protectedAttributeValue = session.getAttribute(protectedAttributeName);

			if (protectedAttributeValue == null) {
				continue;
			}

			protectedAttributes.put(protectedAttributeName, protectedAttributeValue);
		}

		session.invalidate();

		session = request.getSession(true);

		for (String protectedAttributeName : protectedAttributeNames) {
			Object protectedAttributeValue = protectedAttributes.get(protectedAttributeName);

			if (protectedAttributeValue == null) {
				continue;
			}

			session.setAttribute(protectedAttributeName, protectedAttributeValue);
		}

		return session;
	}

	@Override
	public JSONObject doChangeEmail(User user, long companyId, long groupId, HttpServletRequest request,
			HttpServletResponse response, ServiceContext serviceContext, String oldEmail, String newEmail,
			String techId) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		User oldUser = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, oldEmail);

		if (oldUser == null) {
			result.put("statusCode", 404);
			result.put("message", "not found user with emailadress: " + oldEmail);
			return result;
		} else {
			if (oldUser.getUserId() != user.getUserId()) {
				result.put("statusCode", 401);
				result.put("message", "does not have permission to update");
				return result;
			}
		}

		User existedUser = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, newEmail);

		if (existedUser != null) {
			result.put("statusCode", 409);
			result.put("message", "dupplicate email");
			return result;
		}

		Applicant applicant = ApplicantLocalServiceUtil.fetchByF_GID_MCN_MCPK(groupId, "dvcqg", techId);

		if (applicant == null || applicant.getMappingUserId() != user.getUserId()
				|| !applicant.getContactEmail().equals(oldEmail)) {
			result.put("statusCode", 401);
			result.put("message", "does not have permission to update");
			return result;
		}

		oldUser.setEmailAddress(newEmail);

		oldUser = UserLocalServiceUtil.updateUser(oldUser);

		applicant.setContactEmail(newEmail);

		applicant = ApplicantLocalServiceUtil.updateApplicant(applicant);

		Applicant applicant0 = ApplicantLocalServiceUtil.fetchByF_APLC_GID(0, applicant.getApplicantIdNo());

		if (applicant0 != null) {
			applicant0.setContactEmail(newEmail);
			applicant0 = ApplicantLocalServiceUtil.updateApplicant(applicant0);
		}

		result.put("statusCode", 200);
		result.put("message", "success");

		return result;
	}

	private String _DEFAULT_CLASS_NAME = "dvcqg";

}
