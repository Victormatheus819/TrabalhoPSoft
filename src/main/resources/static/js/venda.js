
var produto1 = {codigo: 01, nome: 'Produto1', valor: 11.49};
var produto2 = {codigo: 02, nome: 'Produto2', valor: 22.90};
var produto3 = {codigo: 03, nome: 'Produto3', valor: 59.99};

var produtos = [produto1, produto2, produto3];

document.addEventListener("DOMContentLoaded", function(){
    produtos.forEach(adicionarProduto);
    
});

function atualizarTabela() {
    document.getElementById('tbody').innerHTML = "";
    produtos.forEach(adicionarProduto);
}

function excluirItem(codigo){
  document.getElementById("tbody").deleteRow(0);
  // produtos.splice(produtos.indexOf(codigo), 1);
  // atualizarTabela();
}

function adicionarProduto(){
  const codigo = document.getElementById("codigo").value;
  const nome = "teste";
  const valor = 10.0;

  var body = document.getElementById('tbody');

  if(codigo) {
    var row = body.insertRow(0);
    var cel1 = row.insertCell(0);
    var cel2 = row.insertCell(1);
    var cel3 = row.insertCell(2);
    var cel4 = row.insertCell(3);

    cel1.innerHTML = codigo;
    cel2.innerHTML = nome;
    cel3.innerHTML = valor;
    cel4.innerHTML = `<button id="excluir" type="reset" onclick="excluirItem(this.parentNode.parentNode.firstChild.innerHTML)">Excluir</button>`
  }
}