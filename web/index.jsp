<%--
  Created by IntelliJ IDEA.
  User: maciek
  Date: 23.01.17
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
      <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
      <!-- Latest compiled and minified JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
      <link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" media="all" href="style.css"/>
  </head>
  <body>

      <div class="row">
          <c:forEach items="${manyNews}" var="news">
              <div class="col-md-4">
                  <section class="card">
                      <h1><strong><c:out value="${news.highlight}"/></strong> <c:out value="${news.title}"/></h1>
                      <h2><c:out value="${news.content}"/></h2>
                          <%--<td>Employee ID: <c:out value="${employee.eid}"/></td>--%>
                          <%--<td>Employee Pass: <c:out value="${employee.ename}"/></td>--%>
                      </tr>
                  </section>
              </div>
          </c:forEach>
      </div>




      <div class="fixed-action-btn" data-toggle="modal" data-target="#myModal">
          <a class="btn-floating btn-large blue">
              <i class="large material-icons">add</i>
          </a>
      </div>

      <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
          <div class="modal-dialog" role="document">
              <div class="modal-content">
                  <div class="modal-body">
                      <form action="" http://localhost:8080/MeNowEE_war_exploded/dupa method="POST">
                      <div class="form-group">
                          <label for="exampleInputEmail1">Enter new source name</label>
                          <input type="text" name="source" class="form-control" id="exampleInputEmail1" placeholder="Email">
                      </div>
                      <button type="submit" class="btn btn-default">Submit</button>
                      </form>
                  </div>
              </div>
          </div>
      </div>

  </body>
</html>
