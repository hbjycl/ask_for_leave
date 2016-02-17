	<c:if test="${not empty errorMsg}">
		<div class="tips tips-small tips-warning">
			<span class="x-icon x-icon-small x-icon-error"><i class="icon icon-white icon-bell"></i></span>
			<div class="tips-content">${errorMsg}</div>
		</div>
	</c:if>
	<c:if test="${not empty infoMsg}">
		<div class="tips tips-small  tips-success">
			<span class="x-icon x-icon-small x-icon-success"><i class="icon icon-white icon-ok"></i></span>
			<div class="tips-content">${infoMsg}</div>
		</div>
	</c:if>
	<br>