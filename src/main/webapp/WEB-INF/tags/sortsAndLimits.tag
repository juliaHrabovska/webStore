<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sorts-limits">

	<div id="sorts">
		<select class="selectpicker"
			onchange="window.location = $(this).find('option:selected').val();">
			<c:forEach var="entry" items="${pageBean.sorts}" varStatus="loop">
				<option value="${entry.value}"
					<c:if test="${(entry.key.name eq filter.sort) && (entry.key.sortType eq filter.sortType)}">
					<c:out value="selected" /></c:if>>${entry.key.text}</option>
			</c:forEach>
		</select>
	</div>
	<div id="limits">
		<div>
			<select class="selectpicker"
				onchange="window.location = $(this).find('option:selected').val();">
				<c:forEach var="entry" items="${pageBean.limits}" varStatus="loop">
					<option value="${entry.value}"
						<c:if test="${entry.key eq filter.limit}">
						<c:out value="selected" /></c:if>>${entry.key}</option>
				</c:forEach>
			</select>
		</div>
	</div>
</div>