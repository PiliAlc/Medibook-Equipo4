const data = [
  {id:1, name:"pasillo", description:"pasillo de la clinica",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/clinica/pasillo.jpg?raw=true"]},
  {id:2, name:"reception", description:"recepcion de la clinica",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/clinica/reception.jpg?raw=true"]},
  {id:3, name:"reception-2", description:"recepcion de la clinica",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/clinica/reception-2.jpg?raw=true"]},
  {id:4, name:"Sala 1", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-1.jpg?raw=true"]},
  {id:5, name:"Sala 2", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-2.jpg?raw=true"]},
  {id:6, name:"Sala 3", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-3.jpg?raw=true"]},
  {id:7, name:"Sala 4", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-4.jpg?raw=true"]},
  {id:8, name:"Sala 5", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-5.jpg?raw=true"]},
  {id:9, name:"Sala 6", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-6.jpg?raw=true"]},
  {id:10, name:"Sala 7", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-7.jpg?raw=true"]},
  {id:11, name:"Sala 8", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-8.jpg?raw=true"]},
  {id:12, name:"Sala 9", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-9.jpg?raw=true"]},
  {id:13, name:"Sala 10", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-10.jpg?raw=true"]},
  {id:14, name:"Sala 11", description:"general",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/general/img-11.jpg?raw=true"]},
  {id:15, name:"Sala 1", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-1.jpg?raw=true"]},
  {id:16, name:"Sala 2", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-2.jpg?raw=true"]},
  {id:17, name:"Sala 3", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-3.jpg?raw=true"]},
  {id:18, name:"Sala 4", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-4.jpg?raw=true"]},
  {id:19, name:"Sala 5", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-5.jpg?raw=true"]},
  {id:20, name:"Sala 6", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-6.jpg?raw=true"]},
  {id:22, name:"Sala 8", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-8.jpg?raw=true"]},
  {id:23, name:"Sala 9", description:"odontologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/odontologia/img-9.jpg?raw=true"]},
  {id:24, name:"Sala 1", description:"oftalmologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/oftalmologo/img-1.jpg?raw=true"]},
  {id:25, name:"Sala 2", description:"oftalmologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/oftalmologo/img-2.jpg?raw=true"]},
  {id:26, name:"Sala 3", description:"oftalmologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/oftalmologo/img-3.jpg?raw=true"]},
  {id:27, name:"Sala 4", description:"oftalmologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/oftalmologo/img-4.jpg?raw=true"]},
  {id:28, name:"Sala 5", description:"oftalmologia",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/oftalmologo/img-5.jpg?raw=true"]},
  {id:29, name:"Sala 1", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-1.jpg?raw=true"]},
  {id:30, name:"Sala 2", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-2.jpg?raw=true"]},
  {id:31, name:"Sala 3", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-3.jpg?raw=true"]},
  {id:32, name:"Sala 4", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-4.jpg?raw=true"]},
  {id:33, name:"Sala 5", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-5.jpg?raw=true"]},
  {id:34, name:"Sala 6", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-6.jpg?raw=true"]},
  {id:35, name:"Sala 7", description:"quirofano",url:["https://github.com/VICT0R89/ProyectoImgs/blob/main/quirofano/img-7.jpg?raw=true"]},
]

export default data