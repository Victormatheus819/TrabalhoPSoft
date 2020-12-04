function adicionarItem(venda) {
  var codigo = document.getElementById("codigo").value;
  var quant = document.getElementById("quant").value;
  var sub  = document.getElementById('subtotal');
  var c= 0;
  if(quant == ""){
    quant = "1";
  }
  $.ajax({
      url : '/criaItem/' + codigo + '/' + quant ,
      type :'GET',
      cache: false,
      timeout: 600000,
      success : function(data) {  
        if(data == null){
          alert("Erro : Produto não cadastrado");
          return;
        }

        var body = document.getElementById('tbody');

        for(var i=0; i < quant; i++){
          var row = body.insertRow(0);
          var cel1 = row.insertCell(0);
          var cel2 = row.insertCell(1);
          var cel3 = row.insertCell(2);
          var cel4 = row.insertCell(3);
    
          cel1.innerHTML = data.codigoBarras;
          cel2.innerHTML = data.nome;
          cel3.innerHTML = data.preco;
          cel4.innerHTML = '<button id="excluir" type="reset" onclick="excluirItem(this, ' + data.codigoBarras + ')">Excluir</button>'
          c= c + data.preco;
        }
        sub.innerHTML= c;
        console.log(c);
      },
      error : function() {
        alert("Erro : Produto não cadastrado");
      }
  });
  document.getElementById("codigo").value = "";
  document.getElementById("quant").value = "";
}

function excluirItem(row, codigoBarras){

  $.ajax({
    url : '/removerItem/' + codigoBarras,
    type :'GET',
    cache: false,
    timeout: 600000,
    success : function(data) {  
      if(data){
        var i = (row.parentNode.parentNode.rowIndex) - 1;
        document.getElementById('tbody').deleteRow(i);
      }
    }
  });
}

function adicionarCliente() {
  var cpf = document.getElementById("cpf").value;
  $.ajax({
      url : '/clienteVenda/'+ cpf ,
      type :'GET',
      cache: false,
      timeout: 600000,
      success : function(data) { 
        if(data == true){
          document.getElementById("popUp").style.display = "none";
        }else{
          alert("Erro : Cliente não cadastrado");
        }
      },
      error : function() {
        alert("Erro : Cliente não cadastrado");
      }
  });
}

function showPopUpCancel(){
  $('#popUpCancel').attr({"style":"display: flex;"});
}

function removerVenda() {
	
  var senhaGerente = document.getElementById("senhaGerente").value;
  $.ajax({
      url : '/removerVenda',
      type :'GET', 
      cache : false,
      data: {senhaGerente : senhaGerente},
      timeout: 600000,
      success : function(data) {  
        if(data == true){
          $('#popUpCancel').attr({"style":"display: none;"});
          window.location.reload();
          return;
        }
        alert("Erro : Gerente não encontrado");
      },
      error : function() {
        alert("Erro : Gerente não encontrado");
      }
  });
}