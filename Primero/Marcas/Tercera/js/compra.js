function almacenar (codigo){
    if(sessionStorage.getItem(codigo)==null)
        sessionStorage.setItem(codigo, 1);
    else
        sessionStorage.setItem(codigo, parseInt(sessionStorage.getItem(codigo))+1);
    actualizarCesta();
}

function actualizarCesta(){
    cesta.innerHTML="";
    if(sessionStorage.length == 0)
        cesta.innerHTML = "<h5>No tienes productos en el carrito</h5>";
    else {
        cesta.innerHTML = "<table width=90% class='pro'><tr><th>PRODUCTO</th><th>UNIDADES</th><th>QUITAR</th></tr></table>";
        for(i=0; i<sessionStorage.length; i++){
            cesta.innerHTML += "<table width=90% class='pro'><tr><td><img src='imagenes/iconos2/"
                +sessionStorage.key(i)+".jpg'></td><td>"+sessionStorage.getItem(sessionStorage.key(i))+"</td>"+
                "<td><img src='imagenes/papelera.png' onclick=borrar('"+sessionStorage.key(i)+"')></td></table>";
        }
    }
}
function borrar(codigo){
    if(parseInt(sessionStorage.getItem(codigo))==1)
        sessionStorage.removeItem(codigo);
    else
        sessionStorage.setItem(codigo, parseInt(sessionStorage.getItem(codigo))-1);
    actualizarCesta();
}

function vaciarCesta(){
    sessionStorage.clear();
    actualizarCesta();
}