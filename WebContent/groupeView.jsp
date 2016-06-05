<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html"%>
<script type="text/javascript">

</script>

<div class="col-md-12">

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Liste Groupe</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>Numero</th>
						<th>Libelle</th>
						<th>Abreviation</th>
						<th>Code</th>
						<th>Niveau</th>
						<th>Modifier</th>
						<th>Supprimer</th>
						
						
						
					</tr>
					<%
						int i = 1;
					%>
					<c:forEach items="${requestScope.liste}" var="liste">
						<tr>

							<td><%=i++%></td>
							<td><c:out value="${liste.libelle}"></c:out></td>
							<td><c:out value="${liste.abreviation}"></c:out></td>
							<td><c:out value="${liste.code}"></c:out></td>
							<td><c:out value="${liste.niveau.libelle}"></c:out></td>
							

							<td><a href=GroupeServlet?action=update&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default" >

										<span class="glyphicon glyphicon-edit"></span>
									</button>
							</a></td>
							
							<td><a href=GroupeServlet?action=delete&id=<c:out value="${liste.id}"></c:out>>
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-remove"></span>

									</button>
							</a></td>
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

<div class="col-md-12">
	<!-- Horizontal Form -->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Modifier Groupe</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
	
<form class="form-horizontal" action="GroupeServlet" method="post">
			<div class="box-body">
			
			<input type="hidden" name="id" value="${requestScope.obj.id }">
			
								
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Libelle</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="libelle" value="${requestScope.obj.libelle }" required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Abreviation</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="abreviation" value="${requestScope.obj.abreviation }" required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Code</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							 name="code" value="${requestScope.obj.code }" required> 
					</div>
				</div>
				
				
				<div class="form-group">
                  
                  <label for="inputEmail3" class="col-sm-2 control-label">Niveau</label>
                  <div class="col-sm-10">
                  <select class="form-control" name="niveaugroupe">
                 		 <c:forEach items="${requestScope.listeNiveau}" var="listeNiveau">          
                  						
						<option value='<c:out value="${listeNiveau.id}"></c:out>' ><c:out value="${listeNiveau.libelle}"></c:out></option>	
					</c:forEach>									
                   </select>
                  
                  </div>
                </div>				
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="reset" class="btn btn-default">Cancel</button>
				<button type="submit" class="btn btn-info pull-right">Modifier</button>
			</div>
			<!-- /.box-footer -->
			</form>
	</div>
	<!-- /.box -->
	<!-- general form elements disabled -->
</div>

<%@include file="footer.html"%>
