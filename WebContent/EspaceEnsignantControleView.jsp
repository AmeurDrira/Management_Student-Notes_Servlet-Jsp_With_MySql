<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="ensignantHeader.jsp"%>

<div class="col-md-12">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Liste Groupe</h3>
		</div>
		<form class="form-horizontal" action="ExamenControleServlet" method="get">
			<div class="box-body">
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Groupe</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idgroupe">
                 		 <c:forEach items="${requestScope.list}" var="list">          
                  						
						<option value='<c:out value="${list.groupe.id}"></c:out>' ><c:out value="${list.groupe.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>	
                <div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Matiere</label>
                  <div class="col-sm-6">
                  <select class="form-control" name="idmatiere">
                 		 <c:forEach items="${requestScope.list}" var="list">          
                  						
						<option value='<c:out value="${list.matiere.id}"></c:out>' ><c:out value="${list.matiere.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>
				

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				
				<button type="submit" class="btn btn-info pull-right">Chercher</button>
			</div>
			<!-- /.box-footer -->
		</form>
		</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

	<!-- /.box -->
	<!-- general form elements disabled -->

<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Saisie Note De  ${requestScope.groupe.libelle }   Pour la Matiere   ${requestScope.matiere.libelle } Session Rattrapage</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
	
<form class="form-horizontal" action="ExamenControleServlet" method="post">
<input type="hidden" name="idgroupe" value="${requestScope.groupe.id }">
<input type="hidden" name="idmatiere" value="${requestScope.matiere.id }">

			<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Numero Compostage</th>
						<th>Note Examen Rattrapage</th>			
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.listeNote}" var="listeNote">
						<tr>
							<td><%=i++%></td>
							<td><c:out value="${listeNote.numcompostage}"></c:out></td>
							<td><input type="number" class="form-control" name="${listeNote.numcompostage}" required/></td>
													

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Enregistrer</button>
			</div>
			<!-- /.box-footer -->
			</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
