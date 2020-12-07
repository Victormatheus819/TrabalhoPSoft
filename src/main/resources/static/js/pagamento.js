function calcularTroco(){
    var valorCompra = document.getElementById('valorTotal').value;
    var valorPago = document.getElementById('valorPago').value;
    document.getElementById('troco').innerHTML = valorPago - valorCompra;
}