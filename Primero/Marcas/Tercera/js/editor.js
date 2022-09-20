function negrita(){
    document.execCommand("bold", "false", null);
}
function cursiva(){
    document.execCommand("italic", "false", null);
}
function subrayado(){
    document.execCommand("underline", "false", null);
}
function alini(){
    document.execCommand("justifyleft", "false", null);
}
function alinc(){
    document.execCommand("justifycenter", "false", null);
}
function alind(){
    document.execCommand("justifyright", "false", null);
}
function alinf(){
    document.execCommand("justifyfull", "false", null);
}
function lno(){
    document.execCommand("insertunorderedlist", false, null);
}
function lor(){
    document.execCommand("insertorderedlist", false, null);
}
function subi(){
    document.execCommand("subscript", false, null);
}
function supi(){
    document.execCommand("superscript", false, null);
}
function fco(){
    var color = prompt("Introduce aquí el color de la fuente");
    document.execCommand("forecolor", false, color);
}
function bco(){
    var color = prompt("Introduce aquí el color de fondo");
    document.execCommand("backcolor", false, color);
}
function insertarimg(){
    var imagen = prompt("Introduce la ruta y el nombre del archivo");
    document.execCommand("insertimage", false, imagen);
}

function hipervinculo(){
    var direccion = prompt("Introduce la URL", "http://");
    document.execCommand("createlink", false, direccion);
}

function publicar(){
    var contenido = document.getElementById("contenido").innerHTML;
    document.getElementById("mensajes").innerHTML = contenido;
}
