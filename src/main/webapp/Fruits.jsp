<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fruits</title>
</head>
<body>

    <div align="center">
        <c:if test="${fruits != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${fruits == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${fruits != null}">
                        Edit Fruits
                    </c:if>
                    <c:if test="${fruits == null}">
                  
                    </c:if>
                </h2>
            </caption>
                <c:if test="${fruits != null}">
                    <input type="hidden" name="fruit_id" value="<c:out value='${fruits.fruit_id}' />" />
                </c:if>           
            <tr>
                <th>Genus: </th>
                <td>
                    <input type="text" name="genus" size="45"
                            value="<c:out value='${fruits.genus}' />"
                        />
                </td>
            </tr>
             
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${fruits.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Fruit_id: </th>
                <td>
                    <input type="text" name="fruit_id" 
                            value="<c:out value='${fruits.fruit_id}' />"
                    />
                </td>
            </tr>
              <tr>
                <th>Family: </th>
                <td>
                    <input type="text" name="family" 
                            value="<c:out value='${fruits.family}' />"
                    />
                </td>
            </tr>
            
              <tr>
                <th>Order_name: </th>
                <td>
                    <input type="text" name="order_name" 
                            value="<c:out value='${fruits.order_name}' />"
                    />
                </td>
            </tr>
            
              <tr>
                <th>Carbohydrates: </th>
                <td>
                    <input type="text" name="carbohydrates" 
                            value="<c:out value='${fruits.carbohydrates}' />"
                    />
                </td>
            </tr>
            
               <tr>
                <th>Protein: </th>
                <td>
                    <input type="text" name="protein" 
                            value="<c:out value='${fruits.protein}' />"
                    />
                </td>
            </tr>
            
               <tr>
                <th>Fat: </th>
                <td>
                    <input type="text" name="fat" 
                            value="<c:out value='${fruits.fat}' />"
                    />
                </td>
            </tr>
            
               <tr>
                <th>Calories: </th>
                <td>
                    <input type="text" name="calories" 
                            value="<c:out value='${fruits.calories}' />"
                    />
                </td>
            </tr>
            
     
            
            <tr>
                <th>Sugar: </th>
                <td>
                    <input type="text" name="sugar" 
                            value="<c:out value='${fruits.sugar}' />"
                    />
                </td>
            </tr>
            
             
             
              
            
     
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>