function entrar() {
  const usuario = document.getElementById('usuario').value;
  const senha = document.getElementById('senha').value;

  fetch('http://localhost:8080/login')
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao buscar dados');
      }
      return response.json();
    })
    .then(data => {
      data.forEach(login => {
        if(login.usuario === usuario && login.senha === senha){
          if(login.tipo_permissao == "admin"){
            window.location.href = "tela_inicial_admin.html";
          } else if(login.tipo_permissao == "desenvolvedor"){
            window.location.href = "tela_inicial.html";
          } else{
            window.location.href = "tela_inicial_financas.html"
          }
        }
      });
    })
    .catch(error => {
      alert('Erro ao carregar cadastros!');
    });
}

function cadastrar(){
  document.getElementById('formCadastro').addEventListener('submit', function(event) {
  event.preventDefault(); // evitar que o formulário recarregue a página

  // Captura dados do formulário

  const senha = document.getElementById('senha').value;
  const confSenha = document.getElementById('confirmarSenha').value;

  if(senha != confSenha){
    alert("Erro na confirmação!");
    exit();
  }

  const selecionado = document.querySelector('input[name="tipo"]:checked');

  const cadastro = {
    nome: document.getElementById('nome').value,
    usuario: document.getElementById('usuario').value,
    senha: document.getElementById('senha').value,
    tipo_permissao: selecionado.value
  }

  // Enviar dados para o backend
  fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(cadastro)
  })
  .then(response => {
    if (!response.ok) throw new Error('Erro ao salvar veículo');
    return response.json();
  })
  .then(data => {
    alert('Cadastro feito com sucesso!');
    // Limpar o formulário se quiser
    this.reset();
    window.location.href = 'index.html';
  })
  .catch(error => {
    console.error(error);
    alert('Erro ao efetuar cadastro.');
  });
});
}