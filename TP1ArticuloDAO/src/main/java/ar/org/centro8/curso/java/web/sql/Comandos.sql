use negocioWeb;
select * from clientes;
select 
    c.id idCliente,nombre,apellido,fenaci,tipoDocumento,numeroDocumento, telefono, email, comentarios, 
    idDireccion,calle,numero,piso,depto,torre,codigoPostal,ciudad,provincia,pais
    from clientes c join direcciones d on c.idDireccion = d.id;

