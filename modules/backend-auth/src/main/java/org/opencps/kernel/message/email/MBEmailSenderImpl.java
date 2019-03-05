
package org.opencps.kernel.message.email;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import org.opencps.kernel.message.MBMessageEntry;
import org.osgi.service.component.annotations.Component;

/**
 * @author trungnt
 */
@Component(immediate = true, service = MBEmailSenderImpl.class)
public class MBEmailSenderImpl implements MBEmailSender {

	private static final Log _log = LogFactoryUtil.getLog(MBEmailSenderImpl.class);
	@Override
	public void send(
		MBMessageEntry messageEntry, String portletId,
		ServiceContext... serviceContexts) {
		_log.debug("===========/////////////// Start send mail");
		if (messageEntry != null && messageEntry.isSendEmail()) {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setSubject(messageEntry.getEmailSubject());
			mailMessage.setTo(messageEntry.getToAddress());
			mailMessage.setBody(messageEntry.getEmailBody());
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(messageEntry.getFrom());
			//mailService.sendEmail(mailMessage);
			MailServiceUtil.sendEmail(mailMessage);
			_log.debug("===========/////////////// Send to " + messageEntry.getToAddress()[0]);
		}
		_log.debug("===========/////////////// end send mail");
	}
	
	@BeanReference(type = MailService.class)
	protected MailService mailService;

}
