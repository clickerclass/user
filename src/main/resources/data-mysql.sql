INSERT IGNORE  INTO `rol` (`id`, `name`) VALUES ('1', 'PRODUCTOS_CONSULTA'), ('2', 'PRODUCTOS_ADMON'), ('3', 'CAMPANNAS'), ('4', 'ORDENES_CONSULTA'), ('5', 'ORDENES_ADMON '), ('6', 'CLIENTES_CONSULTA'), ('7', 'CLIENTES_ADMON');
INSERT IGNORE  INTO `user_type` (`id`, `name`) VALUES (1, 'Cliente'),(2, 'Colaborador');
INSERT IGNORE  INTO `document_type` (`id`, `name`) VALUES ('1', 'Cédula'), ('2', 'Tarjeta de identidad'), ('3', 'Cédula de Extranjería'), ('4', 'Pasaporte');
INSERT IGNORE  INTO `user` (`id`, `last_name`, `email`, `document`, `birth_date`, `name`, `user_name`, `document_type_id`, `user_type_id`) VALUES('3fc5cc0a-5bf5-4f5d-aa8d-df617ad919f9', 'ALCALA', 'ALEJOAB12@HOTMAIL.COM', '1010194766', '1990-07-16 08:28:43', 'MANUEL', 'ALEJOAB12', 1, 1);
INSERT IGNORE  INTO `authentication` (`id`, `active`, `password`, `creation_date`, `user_id`) VALUES (1, 1, '$2a$10$.pN3BHZjRcScsTVqSXOmSu9k7F4qXyL5sxcmRMdZ0QUnqmRedeARq', '2020-05-31 23:32:05', '3fc5cc0a-5bf5-4f5d-aa8d-df617ad919f9');
INSERT IGNORE  INTO `user_type_rol` (`id`, `user_type_id`,`rol_id`) VALUES (1, 2,1), (2, 2,2), (3, 2,3), (4, 2,4);
