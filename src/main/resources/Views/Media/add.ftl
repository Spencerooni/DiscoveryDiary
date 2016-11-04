<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<form method="post">
    <div class="form-group">
        <label for="title">Title</label>
        <input name="title" type="text" class="form-control" required />
    </div>

    <div class="form-group">
        <label for="author">Author</label>
        <input name="author" type="text" class="form-control" required />
    </div>

    <div class="form-group">
            <label for="description">Description</label>
            <input name="description" type="text" class="form-control" required />
        </div>

    <div class="form-group">
            <label for="category">Category</label>
            <input name="category" type="text" class="form-control" required />
        </div>

    <div class="form-group">
            <label for="publicationDate">Publication Year</label>
            <input name="publicationDate" type="text" class="form-control" required />
        </div>

     <div class="form-group">
                <label for="imageUrl">Image URL</label>
                <input name="imageUrl" type="text" placeholder="Leave blank for default image" class="form-control"/>
            </div>

    <input type="submit" value="Confirm" class="btn btn-primary" />
    <a class="btn btn-default" href="/people">Cancel</a>
</form>

</@layoutTemplate.layout>