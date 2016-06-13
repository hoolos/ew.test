
<!DOCTYPE html>
<html>
<#include "/includes/header.ftl">
<body>
	<form action="/allnotes" id="noteForm" method="post">
		<p>
			<label>Поиск по заголовку: </label><input type="text" name="noteHeaderToFind" value=${searchHeaderValue!} />
		</p>
		<select id="noteTag" name="tag">
		<option value="">Выбрать тэг</option>
		</select>
		<!-- 
		<#if noteTags?? > <select id="noteTag" name="tag">
			<#if selectedTag??>
			<option value="${selectedTag.id}">${selectedTag.name}</option>
			<option value="">Выбрать тэг</option>
			<#else>
			<option value="">Выбрать тэг</option>
			</#if>
			 <#list noteTags as noteTag>
			<option value="${noteTag.id}">${noteTag.name}</option> </#list>
		</select> </#if>
		 -->
		<p>
			<input type="submit" value="Submit" /> <input type="reset"
				value="Reset" />
		</p>
	</form>
	<#if notes?? > <#list notes as note>
	<div>${note.header!}</div>
	</#list> </#if>
</body>
</html>
