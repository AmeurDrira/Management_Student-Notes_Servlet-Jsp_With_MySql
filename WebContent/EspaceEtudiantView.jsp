<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="etudiantHeader.jsp"%>
<div class="col-md-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Note</h3>
		</div>
		
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Matiere </th>
						<th>Note TP</th>
						<th>Note TD</th>
						<th>Note Presentielle</th>
						<th>Note Examen</th>
						
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.listNote}" var="listNote">
						<tr>

							<td><%=i++%></td>
							<td><c:out value="${listNote.matiereensignier.matiere.libelle}"></c:out></td>
							<td><c:out value="${listNote.notetp}"></c:out></td>
							<td><c:out value="${listNote.notetd}"></c:out></td>
							<td><c:out value="${listNote.notepresentielle}"></c:out></td>
							<td><c:out value="${listNote.noteexamen}"></c:out></td>
		
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>

	<!-- /.box -->
	<!-- general form elements disabled -->


<%@include file="footer.html"%>
