<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HeyCopy Admin</title>
    </head>
    <body>
        <h2>Upload Strings File (<span style="color: red">DANGEROUS</span>)</h2>
        <g:uploadForm action="upload">
            Platform
            <select name="platform">
                <option value="All">All</option>
                <option value="Android">Android</option>
                <option value="iOS">iOS</option>
            </select>
            Product
            <select name="product">
                <option value="All">All</option>
                <option value="ProductX">FIND_ME_AND_EDIT</option>
            </select>
            <br/>
            <input type="file" name="myFile" />
            <input type="submit" />
        </g:uploadForm>

        <h2>Export Strings File</h2>
        <g:form name="exportForm" action="download">
            Platform
            <select name="platform" multiple="true">
                <option value="All">All</option>
                <option value="Android">Android</option>
                <option value="iOS">iOS</option>
            </select>
            Product
            <select name="product" multiple="true">
                <option value="All">All</option>
                <option value="ProductX">FIND_ME_AND_EDIT</option>
            </select>
            Format
            <select name="format">
                <option value="XML">XML</option>
                <option value="JSON">JSON</option>
            </select>
            
            <input type="submit" />
        </g:form>
        You can also curl -d product=All http://SERVER:PORT/HeyCopy/admin/download
    </body>
</html>
