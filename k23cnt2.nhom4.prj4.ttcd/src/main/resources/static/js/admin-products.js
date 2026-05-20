function openAddModal(){

    document.getElementById("modalTitle").innerText =
        "Thêm sản phẩm";

    document.getElementById("productId").value = "";

    document.getElementById("name").value = "";
    document.getElementById("slug").value = "";
    document.getElementById("imageUrl").value = "";
    document.getElementById("price").value = "";
    document.getElementById("description").value = "";

    document.getElementById("productModal").style.display =
        "flex";
}

function closeModal(){

    document.getElementById("productModal").style.display =
        "none";
}

async function saveProduct(){

    const id =
        document.getElementById("productId").value;

    const product = {

        name:
        document.getElementById("name").value,

        slug:
        document.getElementById("slug").value,

        imageUrl:
        document.getElementById("imageUrl").value,

        basePrice:
        document.getElementById("price").value,

        description:
        document.getElementById("description").value,

        isActive:true
    };

    let url = "/api/admin/products";
    let method = "POST";

    if(id){

        url += "/" + id;
        method = "PUT";
    }

    await fetch(url, {

        method: method,

        headers:{
            "Content-Type":"application/json"
        },

        body: JSON.stringify(product)
    });

    location.reload();
}

async function editProduct(id){

    const response =
        await fetch("/api/admin/products/" + id);

    const product =
        await response.json();

    document.getElementById("modalTitle").innerText =
        "Sửa sản phẩm";

    document.getElementById("productId").value =
        product.id;

    document.getElementById("name").value =
        product.name;

    document.getElementById("slug").value =
        product.slug;

    document.getElementById("imageUrl").value =
        product.imageUrl;

    document.getElementById("price").value =
        product.basePrice;

    document.getElementById("description").value =
        product.description;

    document.getElementById("productModal").style.display =
        "flex";
}

async function deleteProduct(id){

    const confirmDelete =
        confirm("Bạn có chắc muốn xóa?");

    if(!confirmDelete) return;

    await fetch("/api/admin/products/" + id, {

        method:"DELETE"
    });

    location.reload();
}