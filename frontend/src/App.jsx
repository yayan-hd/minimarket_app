import React from "react"

export default function MinimarketUI() {
  const [activeMenu, setActiveMenu] = React.useState("dashboard")
  const [products, setProducts] = React.useState([])
  const [suppliers, setSuppliers] = React.useState([])
  const [categories, setCategories] = React.useState([])
  const [cashiers, setCashiers] = React.useState([])
  const [stockLogs, setStockLogs] = React.useState([])

  React.useEffect(() => {
    loadProducts()
    loadSuppliers()
    loadCategories()
    loadCashiers()
    loadStockLogs()
  }, [])

  const loadProducts = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/produk")
      const data = await response.json()
      setProducts(data)
    } catch (err) {
      console.log(err)
    }
  }

  const loadSuppliers = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/supplier")
      const data = await response.json()
      setSuppliers(data)
    } catch (err) {
      console.log(err)
    }
  }

  const loadCategories = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/kategori")
      const data = await response.json()
      setCategories(data)
    } catch (err) {
      console.log(err)
    }
  }

  const loadCashiers = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/kasir")
      const data = await response.json()
      setCashiers(data)
    } catch (err) {
      console.log(err)
    }
  }

  const loadStockLogs = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/stok-log")
      const data = await response.json()
      setStockLogs(data)
    } catch (err) {
      console.log(err)
    }
  }

  const renderContent = () => {
    switch (activeMenu) {
      case "pos":
        return <POSPage />

      case "inventory":
        return <InventoryPage products={products} />

      case "pembelian":
        return <PembelianPage />

      case "supplier":
        return <SupplierPage suppliers={suppliers} />

      case "kategori":
        return <KategoriPage categories={categories} />

      case "kasir":
        return <KasirPage cashiers={cashiers} />

      case "stoklog":
        return <LogStokPage stockLogs={stockLogs} />

      default:
        return <Dashboard products={products} />
    }
  }

  return (
    <div className="min-h-screen bg-gray-100 flex">
      {/* Sidebar */}
      <aside className="w-72 bg-slate-900 text-white p-6 shadow-2xl">
        <h1 className="text-3xl font-bold mb-10 tracking-wide">
          MiniMarket POS
        </h1>

        <nav className="space-y-3">
          <SidebarButton
            title="Dashboard"
            active={activeMenu === "dashboard"}
            onClick={() => setActiveMenu("dashboard")}
          />

          <SidebarButton
            title="POS Penjualan"
            active={activeMenu === "pos"}
            onClick={() => setActiveMenu("pos")}
          />

          <SidebarButton
            title="Inventory"
            active={activeMenu === "inventory"}
            onClick={() => setActiveMenu("inventory")}
          />

          <SidebarButton
            title="Pembelian"
            active={activeMenu === "pembelian"}
            onClick={() => setActiveMenu("pembelian")}
          />

          <SidebarButton
            title="Supplier"
            active={activeMenu === "supplier"}
            onClick={() => setActiveMenu("supplier")}
          />

          <SidebarButton
            title="Kategori"
            active={activeMenu === "kategori"}
            onClick={() => setActiveMenu("kategori")}
          />

          <SidebarButton
            title="Kasir"
            active={activeMenu === "kasir"}
            onClick={() => setActiveMenu("kasir")}
          />

          <SidebarButton
            title="Log Stok"
            active={activeMenu === "stoklog"}
            onClick={() => setActiveMenu("stoklog")}
          />
        </nav>
      </aside>

      {/* Content */}
      <main className="flex-1 p-8 overflow-auto">
        {renderContent()}
      </main>
    </div>
  )
}

function SidebarButton({ title, active, onClick }) {
  return (
    <button
      onClick={onClick}
      className={`w-full text-left p-4 rounded-2xl transition ${
        active
          ? "bg-blue-600"
          : "hover:bg-slate-800"
      }`}
    >
      {title}
    </button>
  )
}

function Dashboard({ products }) {
  return (
    <div>
      <h1 className="text-4xl font-bold mb-8">
        Dashboard Minimarket
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
        <div className="bg-white p-6 rounded-3xl shadow-xl">
          <h2 className="text-gray-500">
            Total Produk
          </h2>

          <p className="text-4xl font-bold mt-4">
            {products.length}
          </p>
        </div>

        <div className="bg-white p-6 rounded-3xl shadow-xl">
          <h2 className="text-gray-500">
            Supplier
          </h2>

          <p className="text-4xl font-bold mt-4">
            18
          </p>
        </div>

        <div className="bg-white p-6 rounded-3xl shadow-xl">
          <h2 className="text-gray-500">
            Penjualan Hari Ini
          </h2>

          <p className="text-4xl font-bold mt-4">
            Rp 3,5 Jt
          </p>
        </div>

        <div className="bg-white p-6 rounded-3xl shadow-xl">
          <h2 className="text-gray-500">
            Barang Hampir Habis
          </h2>

          <p className="text-4xl font-bold mt-4">
            12
          </p>
        </div>
      </div>
    </div>
  )
}

function POSPage() {
  return (
    <div className="bg-white rounded-3xl shadow-xl p-6">
      <h1 className="text-3xl font-bold mb-6">
        POS Penjualan
      </h1>

      <input
        type="text"
        placeholder="Scan barcode..."
        className="w-full border rounded-2xl px-4 py-3"
      />
    </div>
  )
}

function InventoryPage({ products }) {
  return (
    <div className="bg-white rounded-3xl shadow-xl p-6">
      <h1 className="text-3xl font-bold mb-6">
        Inventory Produk
      </h1>

      <table className="w-full">
        <thead>
          <tr className="bg-slate-900 text-white">
            <th className="p-4">Kode</th>
            <th className="p-4">Nama</th>
            <th className="p-4">Stok</th>
            <th className="p-4">Harga</th>
          </tr>
        </thead>

        <tbody>
          {products.map((item, index) => (
            <tr key={index} className="border-b">
              <td className="p-4">
                {item.kode_barang}
              </td>

              <td className="p-4">
                {item.nama_produk}
              </td>

              <td className="p-4">
                {item.stok}
              </td>

              <td className="p-4">
                Rp {item.harga_jual}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

function PembelianPage() {
  return <div>Pembelian Page</div>
}

function SupplierPage() {
  return <div>Supplier Page</div>
}

function KategoriPage() {
  return <div>Kategori Page</div>
}

function KasirPage() {
  return <div>Kasir Page</div>
}

function LogStokPage() {
  return <div>Log Stok Page</div>
}