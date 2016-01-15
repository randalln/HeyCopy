
<%@ page import="com.heywire.heycopy.HWString" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'HWString.label', default: 'HWString')}" />
		<title>HeyCopy</title>
	</head>
	<body>
		<a href="#list-HWString" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link controller="contact">Contacts</g:link></li>
				<li><g:link controller="admin">Export</g:link></li>
     			<li style="float:right"><g:link controller="contact" action="notifyContacts">Email Changes</g:link></li>
			</ul>
		</div>
		<div id="list-HWString" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="label" title="${message(code: 'HWString.label.label', default: 'Label')}" />
					
						<g:sortableColumn property="copy" title="${message(code: 'HWString.copy.label', default: 'Copy')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'HWString.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="groupBy" title="${message(code: 'HWString.groupBy.label', default: 'Group By')}" />
					
						<g:sortableColumn property="platform" title="${message(code: 'HWString.platform.label', default: 'PF')}" />
					
						<g:sortableColumn property="product" title="${message(code: 'HWString.product.label', default: 'PD')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'HWString.lastUpdated.label', default: 'Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${HWStringInstanceList}" status="i" var="HWStringInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${HWStringInstance.id}">${fieldValue(bean: HWStringInstance, field: "label")}</g:link></td>
					
						<td>${fieldValue(bean: HWStringInstance, field: "copy")}</td>
					
						<td>${fieldValue(bean: HWStringInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: HWStringInstance, field: "groupBy")}</td>
					
						<td>${fieldValue(bean: HWStringInstance, field: "platform")}</td>
					
						<td>${fieldValue(bean: HWStringInstance, field: "product")}</td>
					
						<td><g:formatDate format="yy-MM-dd" date="${HWStringInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${HWStringInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
