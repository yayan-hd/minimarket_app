const API = '/api/produk';

async function loadProduk() {

    try {

        const response = await fetch(API);

        const data = await response.json();

        const table = document.getElementById('produkTable');

        if (!table) return;

        table.innerHTML = '';

        data.forEach(item => {

            table.innerHTML += `
                <tr>
                    <td>${item.id_produk}</td>

                    <td>${item.kode_barang}</td>

                    <td>${item.nama_produk}</td>

                    <td>Rp ${parseInt(item.harga_jual).toLocaleString()}</td>

                    <td>${item.stok}</td>

                    <td>

                        <button class="edit-btn"
                            onclick="editProduk(${item.id_produk})">
                            Edit
                        </button>

                        <button class="delete-btn"
                            onclick="hapusProduk(${item.id_produk})">
                            Hapus
                        </button>

                    </td>
                </tr>
            `;
        });

        const totalProduk = document.getElementById('totalProduk');

        if (totalProduk) {

            totalProduk.innerText = data.length;
        }

    } catch (error) {

        console.error('Gagal load produk:', error);
    }
}

async function tambahProduk() {

    try {

        const data = {

            kode_barang: document.getElementById('kode_barang').value,

            nama_produk: document.getElementById('nama_produk').value,

            harga_jual: document.getElementById('harga_jual').value,

            stok: document.getElementById('stok').value
        };

        await fetch(API, {

            method: 'POST',

            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(data)
        });

        alert('Produk berhasil ditambahkan');

        document.getElementById('kode_barang').value = '';

        document.getElementById('nama_produk').value = '';

        document.getElementById('harga_jual').value = '';

        document.getElementById('stok').value = '';

        loadProduk();

    } catch (error) {

        console.error('Gagal tambah produk:', error);
    }
}

async function hapusProduk(id) {

    const konfirmasi = confirm('Yakin ingin menghapus produk ini?');

    if (!konfirmasi) return;

    try {

        await fetch(`${API}/${id}`, {

            method: 'DELETE'
        });

        alert('Produk berhasil dihapus');

        loadProduk();

    } catch (error) {

        console.error('Gagal hapus produk:', error);
    }
}

async function editProduk(id) {

    const namaBaru = prompt('Masukkan nama produk baru');

    if (!namaBaru) return;

    try {

        const response = await fetch(API);

        const data = await response.json();

        const produk = data.find(item => item.id_produk === id);

        if (!produk) {

            alert('Produk tidak ditemukan');

            return;
        }

        const updatedData = {

            kode_barang: produk.kode_barang,

            nama_produk: namaBaru,

            harga_jual: produk.harga_jual,

            stok: produk.stok
        };

        await fetch(`${API}/${id}`, {

            method: 'PUT',

            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(updatedData)
        });

        alert('Produk berhasil diupdate');

        loadProduk();

    } catch (error) {

        console.error('Gagal update produk:', error);
    }
}

document.addEventListener('DOMContentLoaded', () => {

    loadProduk();
});