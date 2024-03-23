document.addEventListener('DOMContentLoaded', function() {
    const addProductForm = document.getElementById('add-product-form');

    addProductForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const productId = document.getElementById('product-id').value;
        const quantity = document.getElementById('quantity').value;

        // Enviar os dados para a tela de carrinho
        redirectToCart(productId, quantity);
    });

    function redirectToCart(productId, quantity) {
        window.location.href = `cart.html?productId=${productId}&quantity=${quantity}`;
    }
});
