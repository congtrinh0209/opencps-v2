/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.usermgt.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author khoavu
 * @generated
 */
@ProviderType
public interface QuestionFinder {
	public java.util.List<org.opencps.usermgt.model.Question> findQuestionSearch(
		long groupId, String keyword, String domainCode, String govAgencyCode,
		Integer publish, String questionType, Boolean answer,
		String subDomainCode, int start, int limit);

	public int countQuestionSearch(long groupId, String keyword,
		String domainCode, String govAgencyCode, Integer publish,
		String questionType, Boolean answer, String subDomainCode);
}