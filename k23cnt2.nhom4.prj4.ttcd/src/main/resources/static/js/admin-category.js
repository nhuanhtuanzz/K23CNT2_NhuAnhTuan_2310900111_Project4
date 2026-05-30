function openAddModal() {

    document.getElementById("modalTitle").innerText =
        "Thêm danh mục";

    document.getElementById("categoryId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("slug").value = "";
    document.getElementById("imageUrl").value = "";

    document.getElementById("categoryModal").style.display =
        "flex";
}

function closeModal() {

    document.getElementById("categoryModal").style.display =
        "none";
}

async function saveCategory() {

    const id =
        document.getElementById("categoryId").value;

    const category = {

        name:
        document.getElementById("name").value,

        slug:
        document.getElementById("slug").value,

        imageUrl:
        document.getElementById("imageUrl").value
    };

    let url =
        "/api/admin/categories";

    let method =
        "POST";

    if(id){

        url += "/" + id;
        method = "PUT";
    }

    await fetch(url,{
        method: method,
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(category)
    });

    location.reload();
}

async function deleteCategory(id){

    if(!confirm("Bạn có chắc muốn xóa?"))
        return;

    await fetch(
        "/api/admin/categories/" + id,
        {
            method:"DELETE"
        }
    );

    location.reload();
}