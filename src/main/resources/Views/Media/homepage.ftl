

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
                             <div class="details-area">
                        	    <h1><a href="#">${media.title}</a></h1>
                             </div>
                         </div>
                    </div>
                 </a>
             </#list>
        </div>
    </div>
</@layoutTemplate.layout>