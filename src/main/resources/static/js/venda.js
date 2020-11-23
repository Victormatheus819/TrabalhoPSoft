

var produto1 = {codigo: 01, nome: 'Produto1', valor: 11.49};
var produto2 = {codigo: 02, nome: 'Produto2', valor: 22.90};
var produto3 = {codigo: 03, nome: 'Produto3', valor: 59.99};

var produtos = [produto1, produto2, produto3];

document.addEventListener("DOMContentLoaded", function(){
    produtos.forEach(adcionarProduto);
    
});

function atualizarTabela() {
    document.getElementById('tbody').innerHTML = "";
    produtos.forEach(adcionarProduto);
}

function excluirItem(codigo){
    produtos.splice(produtos.indexOf(codigo), 1);
    atualizarTabela();
}

function adcionarProduto(produto){
    var body = document.getElementById('tbody');
    var row = body.insertRow(0);
    var cel1 = row.insertCell(0);
    var cel2 = row.insertCell(1);
    var cel3 = row.insertCell(2);
    var cel4 = row.insertCell(3);
    cel1.innerHTML = produto.codigo;
    cel2.innerHTML = produto.nome;
    cel3.innerHTML = produto.valor;
    cel4.innerHTML = '<button type="reset" onclick="excluirItem(this.parentNode.parentNode.firstChild.innerHTML)">Excluir</button>'
}