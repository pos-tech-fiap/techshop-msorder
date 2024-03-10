document.addEventListener('DOMContentLoaded', function() {
    const cartItemsContainer = document.getElementById('cart-items');
    const removeItemBtn = document.getElementById('remove-item-btn');

    if (removeItemBtn) {
        removeItemBtn.addEventListener('click', function() {
            removeLastCartItem();
        });
    }

    function removeLastCartItem() {
        const cartItems = cartItemsContainer.getElementsByClassName('cart-item');
        if (cartItems.length > 0) {
            cartItems[cartItems.length - 1].remove();
        }
    }

    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('productId');
    const quantity = urlParams.get('quantity');

    if (productId && quantity) {
        const cartItemElement = document.createElement('div');
        cartItemElement.classList.add('cart-item');
        cartItemElement.innerHTML = `
            <span class="item-quantity">${quantity}x</span>
            <span class="item-name">Product ID: ${productId}</span>
        `;
        cartItemsContainer.appendChild(cartItemElement);
    }
});
