const productListEndpoint = 'https://fakestoreapi.com/products';
let originalProductsData = [];

document.addEventListener('DOMContentLoaded', () => {
    fetchData();

    const searchBar = document.querySelector('.search-bar');

    if (!searchBar) {
        console.error('Error: Searchbar element not found.');
        return;
    }

    createSearchInput(searchBar);
});

function fetchData() {
    fetch(productListEndpoint)
        .then(response => response.json())
        .then(data => {
            originalProductsData = data;
            displayProducts(originalProductsData);
        })
        .catch(error => {
            console.error('Error fetching product data:', error);
        });
}

function createSearchInput(searchBar) {
    const searchInput = document.createElement('input');
    searchInput.classList.add('search-box');
    searchInput.placeholder = 'Search products';
    searchInput.addEventListener('input', handleSearch);

    const searchButton = document.createElement('button');
    searchButton.classList.add('search-button');
    searchButton.textContent = 'Search';
    searchButton.addEventListener('click', handleSearchButtonClick);

    searchBar.appendChild(searchInput);
    searchBar.appendChild(searchButton);
}

function displayProducts(products) {
    const productsContainer = document.querySelector('.products');

    if (!productsContainer) {
        console.error('Error: Products container element not found.');
        return;
    }

    productsContainer.innerHTML = ''; // Clear existing products

    products.forEach(product => {
        const productCard = createProductCard(product);
        productsContainer.appendChild(productCard);
    });
}

// ... (rest of the code remains the same)

function handleSearch(event) {
    const query = event.target.value.toLowerCase();
    const filteredProducts = originalProductsData.filter(product => {
        return product.title.toLowerCase().startsWith(query);
    });
    displayProducts(filteredProducts);
}

function handleSearchButtonClick() {
    const searchInput = document.querySelector('.search-box');

    if (!searchInput) {
        console.error('Error: Search input element not found.');
        return;
    }

    handleSearch({ target: searchInput });
}
