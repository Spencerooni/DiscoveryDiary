

<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>
    <section class="main-content-area">
    <div class="container">
        <div class="row">
             <#list medias as media>
                 <a href="/media/${media.id}">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                 	     <div class="box-inner">
                    	     <div class="img-con">
                                 <img src="${media.imageUrl}">
                             </div>
                             <div class="details-area clearfix">
                        	    <h1 class=""><a href="#">${media.title}</a></h1>
                                 <div class="status-icon">
                                    <#if media.status == "Available">
                                        <span class="glyphicon glyphicon-ok green" aria-hidden="true"></span>
                                    </#if>
                                    <#if media.status == "On Loan">
                                        <span class="glyphicon glyphicon-remove red" aria-hidden="true"></span>
                                    </#if>
                                    <#if media.status == "In Disrepair">
                                        <span class="glyphicon glyphicon-minus orange" aria-hidden="true"></span>
                                    </#if>
                                 </div>

                             </div>
                         </div>
                    </div>
                 </a>
             </#list>
        </div>
    </div>
</@layoutTemplate.layout>