function toggleAdminMenu() {

    document
        .getElementById("adminDropdownMenu")
        .classList
        .toggle("show");
}

function handleLogout() {

    localStorage.removeItem("token");
    localStorage.removeItem("user");

    window.location.href = "/auth";
}

/* click ngoài thì đóng menu */

window.onclick = function(e) {

    if (!e.target.closest(".admin-dropdown")) {

        document
            .getElementById("adminDropdownMenu")
            .classList
            .remove("show");
    }
}