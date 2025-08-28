import { Link } from "react-router-dom";

function Header() {
  const redShade = "#C0392B";

  return (
    <header
      style={{
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        padding: "15px 40px",
        position: "fixed",
        top: 0,
        left: 0,
        right: 0,
        background: "#FFFFFF", // white background
        boxShadow: "0 2px 8px rgba(0,0,0,0.1)", // lighter shadow
        zIndex: 1000,
      }}
    >
      {/* Left side */}
      <div style={{ display: "flex", gap: "20px", alignItems: "center" }}>
        <h1 style={{ fontSize: "24px", fontWeight: "bold", color: redShade }}>Wezen</h1>
        <Link
          to="/explore"
          style={{ textDecoration: "none", color: "#333333", fontWeight: "500" }}
        >
          Explore
        </Link>
      </div>

      {/* Right side */}
      <nav style={{ display: "flex", gap: "20px", alignItems: "center" }}>
        <Link to="/about" style={{ textDecoration: "none", color: "#333333" }}>
          About
        </Link>
        <Link to="/contact" style={{ textDecoration: "none", color: "#333333" }}>
          Contact
        </Link>
        <Link
          to="/login"
          style={{
            textDecoration: "none",
            background: redShade, // red button
            color: "#FFFFFF", // white text on button
            padding: "6px 18px",
            borderRadius: "20px",
            fontWeight: "600",
          }}
        >
          Login
        </Link>
      </nav>
    </header>
  );
}

export default Header;
