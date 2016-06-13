
<!DOCTYPE html>
<html>
<#include "/includes/header.ftl">
<body>
	<h1>Заполните заметку</h1>
	<form action="/notes/add"  id="noteForm" method="post">
		<p>
			<label>Заголовок: </label><input type="text" name="header" />
		</p>
		<p>
			<label>Тело: </label><input type="text" name="body" />
		</p>
		<select id="noteTag" name="tag"> 
		<option value="">Выбрать тэг</option>
		</select>
		<!-- 
		<#if noteTags?? > 
		<select id="noteTag" name="tag"> 
		<option value="">Выбрать тэг</option>
			<#list noteTags as noteTag> 
			<option value="${noteTag.id}">${noteTag.name}</option>
			</#list>
		</select> 
		</#if>
		 -->
		<p>
			<input type="submit" value="Submit" /> <input type="reset"
				value="Reset" />
		</p>
	</form>
	<button name="submitWithJson" onclick="EWApp.submitForm($('#noteForm'))" >Submit With Json</button> 
	<span><a href="/allnotes">Просмотрите заметки</a></span>
</body>
</html>
