<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footerInfompresa">
        <div class="isologotipo">
          <img src="../assets/logoBlanco.png" alt="Logo empresa" />
        </div>
        <div class="info">
          <p>2023 Digital House ©</p>
          <p>Todos los Derechos Reservados.</p>
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
  bottom: 0;
  width: 100%;
  background-color: #0d7277;
  color: #fff;
  padding: 20px 0;
  z-index: 9;
  height: auto;
}
.footer-content {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  margin: 0 auto;
  padding: 10px 0;
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
    height: 60px;
    padding: 10px 0;
  }
  .redesSociales {
    margin-bottom: 0px;
    width:200px;
    margin-right: 5px;
    padding-left: 50px;
  }
  .footerInfompresa {
    width:200px;
  }
  .info p{
    font-size: 1.3vh;
  }
  .isologotipo img {
    width: 50px;
  }
  .isologotipo{
    width: 50px;
    height: 100%;
  }
  .redesSociales img {
    max-width: 20px;
    margin-right: 25px;
  }
  .footerInfompresa {
    justify-content: center;
    margin-right: 0vw;
  }
}
</style>
