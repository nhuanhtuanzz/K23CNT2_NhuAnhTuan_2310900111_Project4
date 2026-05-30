async function viewOrderDetail(id){

    const response =
        await fetch("/api/admin/orders/" + id + "/items");

    const items = await response.json();

    let html = "";

    items.forEach(item => {

        html += `

            <div style="
                padding:15px;
                border-bottom:1px solid #eee;
            ">

                <h3 style="margin-bottom:8px;">
                    ${item.productName}
                </h3>

                <p>
                    Phân loại:
                    ${item.variantName || 'Mặc định'}
                </p>

                <p>
                    Số lượng:
                    ${item.quantity}
                </p>

                <p>
                    Giá:
                    ${item.priceAtBuy} đ
                </p>

            </div>
        `;
    });

    document.getElementById("orderItemsContainer")
        .innerHTML = html;

    document.getElementById("orderDetailModal")
        .style.display = "flex";
}

function closeOrderDetailModal(){

    document.getElementById("orderDetailModal")
        .style.display = "none";
}