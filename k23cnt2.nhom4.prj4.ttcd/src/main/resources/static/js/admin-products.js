const API_URL = "/api/admin/products";

async function loadProducts() {

    try {

        const response = await fetch(API_URL);

        const products = await response.json();

        const tableBody =
            document.getElementById("productTableBody");

        tableBody.innerHTML = "";

        products.forEach(product => {

            tableBody.innerHTML += `
            
                <tr>
                
                    <td>${product.id}</td>
                    
                    <td>
                        <img 
                            src="${product.imageUrl}"
                            class="product-image"
                        />
                    </td>
                    
                    <td>${product.name}</td>
                    
                    <td>
                        ${product.basePrice.toLocaleString()} đ
                    </td>
                    
                    <td>
                    
                        <button class="edit-btn">
                            Sửa
                        </button>
                        
                        <button 
                            class="delete-btn"
                            onclick="deleteProduct(${product.id})"
                        >
                            Xóa
                        </button>
                        
                    </td>
                    
                </tr>
            
            `;
        });

    } catch (error) {

        console.error(error);

    }

}

async function deleteProduct(id){

    const confirmDelete =
        confirm("Bạn có chắc muốn xóa?");

    if(!confirmDelete) return;

    try{

        await fetch(`${API_URL}/${id}`,{
            method:"DELETE"
        });

        alert("Xóa thành công!");

        loadProducts();

    }catch(error){

        console.error(error);

    }

}

loadProducts();