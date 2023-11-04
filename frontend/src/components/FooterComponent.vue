<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footerInfompresa">
        <div class="isologotipo">
          <img src="../assets/logoBlanco.png" alt="Logo empresa" />
        </div>
        <div class="info">
          <p>2023 Digital House ©</p>
          <p>Todos los Derechos Reservados</p>
        </div>
      </div>

      <div class="redesSociales">
        <a href="https://www.instagram.com" target="_blank">
          <img src="../assets/instagram.png" alt="Logo de Instagram" />
        </a>

        <a href="https://www.facebook.com" target="_blank">
          <img src="../assets/facebook.png" alt="Logo de Facebook" />
        </a>

        <a href="https://api.whatsapp.com/send?phone=+5491111111111" target="_blank">
          <img src="../assets/whatsapp.png" alt="Logo de Whatsapp" />
        </a>

      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name:'FooterComponent',
};
</script>

<style scoped>
.footer {
  width: 100%;
  background-color: #0d7277;
  color: #fff;
  padding: 20px 0;
}

.footer-content {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.footerInfompresa {
  display: flex;
  justify-content: space-around;
  align-items: center;
  text-align: left;
  margin-right: 20vw;
  width: 360px;
}

.isologotipo img {
  max-width: 100px;
  
}

.info p {
  margin: 0;
}

.redesSociales img {
  max-width: 40px;
  margin-right: 45px;
}
.redesSociales{
  width: 327px;
}

@media only screen and (max-width:480px ){
  .footer {
    height: 170px;
    padding: 10px 0;
  }
  .footer-content {
    flex-direction: column;
    align-items: center;

  }

  .redesSociales {
    margin-bottom: 20px;
    width:350px;
  }
  .footerInfompresa {

    width:350px;
  }
  .info p{
    font-size: 1.3vh;

  }
  .isologotipo img {
  max-width: 60px;
}
.isologotipo{
  width: 80px;

}
.redesSociales img {
  max-width: 20px;
  margin-right: 45px;
}
.footerInfompresa {
  justify-content: center;
  margin-right: 0vw;
}
}
</style>
