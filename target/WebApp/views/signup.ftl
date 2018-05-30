<#import "./layout.ftl" as Main>


<@Main.layout "Home" >
    <#include "header.html">
    <div id="home-section">
       <a href="#" data-toggle="modal" data-target="#exampleModalCenter">
        <h6> Enregistrez vous</h6>
       </a>


        <#--<table class="table">-->
            <#--<thead>-->
            <#--<tr>-->
    <#--<#list form as input>-->
    <#--<th scope="col">${input.dbName}</th>-->
    <#--</#list>-->
            <#--</tr>-->
            <#--</thead>-->
            <#--<tbody>-->
            <#--<tr>-->
                <#--<th scope="row">1</th>-->
                <#--<td>Mark</td>-->
                <#--<td>Otto</td>-->
                <#--<td>@mdo</td>-->
            <#--</tr>-->

            <#--</tbody>-->
        <#--</table>-->

    </div>




<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="POST">
            <div class="modal-body">

    <#list form as input>
<div class="form-group">
    <label for="${input.dbName}">${input.formatName}</label>
    <input type="${input.inputType}" id="${input.dbName}" name="${input.dbName}" class="form-control form-control-lg" placeholder="${input.formatName}">

</div>
    </#list>





            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <input type="submit" class="btn btn-block">
            </div>
            </form>
        </div>
    </div>
</div>


</@Main.layout>