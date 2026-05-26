function openAddModal() {

    document.getElementById("modalTitle").innerText =
        "Thêm sản phẩm";

    document.getElementById("productId").value = "";

    document.getElementById("name").value = "";

    document.getElementById("slug").value = "";

    document.getElementById("price").value = "";

    document.getElementById("description").value = "";

    document.getElementById("categoryId").value = "";

    document.getElementById("productModal").style.display =
        "flex";
}

function closeModal() {

    document.getElementById("productModal").style.display =
        "none";
}

function openEditModal(button) {

    document.getElementById("modalTitle").innerText =
        "Sửa sản phẩm";

    document.getElementById("productId").value =
        button.dataset.id;

    document.getElementById("name").value =
        button.dataset.name;

    document.getElementById("slug").value =
        button.dataset.slug;

    document.getElementById("price").value =
        button.dataset.price;

    document.getElementById("description").value =
        button.dataset.description;

    document.getElementById("categoryId").value =
        button.dataset.category;

    document.getElementById("productModal").style.display =
        "flex";
}

async function saveProduct() {

    const id =
        document.getElementById("productId").value;

    const formData = new FormData();

    formData.append(
        "name",
        document.getElementById("name").value
    );

    formData.append(
        "slug",
        document.getElementById("slug").value
    );

    formData.append(
        "price",
        document.getElementById("price").value
    );

    formData.append(
        "description",
        document.getElementById("description").value
    );

    formData.append(
        "categoryId",
        document.getElementById("categoryId").value
    );

    const imageFile =
        document.getElementById("imageFile").files[0];

    if(imageFile){

        formData.append(
            "imageFile",
            imageFile
        );
    }

    let url = "/admin/products/save";

    if(id){

        url += "/" + id;
    }

    await fetch(url, {

        method: "POST",

        body: formData
    });

    location.reload();
}

async function deleteProduct(id) {

    const confirmDelete =
        confirm("Bạn có chắc muốn xóa?");

    if(!confirmDelete) return;

    await fetch("/api/admin/products/" + id, {

        method: "DELETE"
    });

    location.reload();
}