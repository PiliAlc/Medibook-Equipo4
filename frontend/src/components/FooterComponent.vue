<template>
  <footer class="footer">
    <div class="footer-content">

      <div class="footerInfompresa">
        <div class="isologotipo">
          <img src="../assets/logoBlanco.png" alt="Logo empresa">
        </div>
        <div class="info">
          <p> 2023 Digital House © </p>
          <p> Todos los Derechos Reservados </p>
        </div>
      </div>
    
      <div class="redesSociales">
        <img src="../assets/facebook.png" alt="Logo de Facebook">
        <img src="../assets/whatsapp.png" alt="Logo de Whatsapp">
        <img src="../assets/instagram.png" alt="Logo de Instagram">
      </div>
      
    </div>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      currentYear: new Date().getFullYear(),
    };
  },
};
</script>

<style scoped>
.footer {
  width: 100%;
  background-color: #0F8389;
  color: #fff;
  padding: 20px 0;
}

.footer-content {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.footerInfompresa{
  display: flex;
  justify-content: space-around;
  align-items: center;
  text-align: left;
}

.isologotipo img {
  max-width: 100px;
}

.info p {
  margin: 0;
}

.redesSociales img {
  max-width: 30px;
  margin-right: 10px;
}

@media (max-width: 767px) {
  .footer-content {
    flex-direction: column;
    align-items: center;
  }

  .footerInfompresa, .redesSociales {
    margin-bottom: 20px;
  }
}


</style>