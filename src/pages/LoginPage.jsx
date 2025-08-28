import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();  // useNavigate hook

  const validate = () => {
    const errs = {};
    if (!email) errs.email = "Email is required";
    else if (!/\S+@\S+\.\S+/.test(email)) errs.email = "Email is invalid";
    if (!password) errs.password = "Password is required";
    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const onSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Logging in...");
    }
  };

  // Close button handler navigates back to Landing page
  const handleClose = () => {
    navigate("/");
  };

  return (
    <div
      style={{
        fontFamily: "Arial, sans-serif",
        minHeight: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background:
          "url('https://images.unsplash.com/photo-1567427018141-0584cfcbf1c5?auto=format&fit=crop&w=1950&q=80') no-repeat center/cover",
        backdropFilter: "blur(2px)",
        position: "relative",
        padding: "20px",
      }}
    >
      <div
        style={{
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          backgroundColor: "rgba(0,0,0,0.2)",
          backdropFilter: "blur(2px)",
          zIndex: 0,
        }}
      ></div>

      <div
        style={{
          position: "relative",
          background: "rgba(255, 255, 255, 0.97)",
          padding: "50px 40px",
          borderRadius: "25px",
          width: "100%",
          maxWidth: "400px",
          boxShadow: "0 15px 40px rgba(0,0,0,0.15)",
          zIndex: 1,
          boxSizing: "border-box",
        }}
      >
        {/* Close button */}
        <button
          onClick={handleClose}
          style={{
            position: "absolute",
            top: "15px",
            right: "15px",
            background: "transparent",
            border: "none",
            fontSize: "1.5rem",
            cursor: "pointer",
            color: "#999",
            transition: "color 0.2s",
          }}
          aria-label="Close"
          onMouseOver={(e) => (e.currentTarget.style.color = "#d6366c")}
          onMouseOut={(e) => (e.currentTarget.style.color = "#999")}
        >
          &times;
        </button>

        <h2
          style={{
            textAlign: "center",
            color: "#d6366c",
            marginBottom: "30px",
            fontWeight: "700",
          }}
        >
          Welcome to Wezen
        </h2>

        <form onSubmit={onSubmit} noValidate>
          <input
            placeholder="Email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={{ ...inputStyle, borderColor: errors.email ? "#d6366c" : "#ccc" }}
          />
          {errors.email && <p style={errorText}>{errors.email}</p>}

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            style={{ ...inputStyle, borderColor: errors.password ? "#d6366c" : "#ccc" }}
          />
          {errors.password && <p style={errorText}>{errors.password}</p>}

          <button type="submit" style={buttonStyle}>
            Login
          </button>
        </form>

        <p style={{ marginTop: "20px", textAlign: "center", color: "#555" }}>
          Don't have an account?{" "}
          <Link
            to="/signup"
            style={{ color: "#d6366c", fontWeight: "bold", textDecoration: "none" }}
          >
            Signup
          </Link>
        </p>
      </div>
    </div>
  );
}

const inputStyle = {
  display: "block",
  margin: "12px 0",
  padding: "12px",
  width: "100%",
  borderRadius: "10px",
  border: "1px solid #ccc",
  outline: "none",
  transition: "border-color 0.2s",
  fontSize: "1rem",
  boxSizing: "border-box",
};

const buttonStyle = {
  background: "#d6366c",
  color: "#fff",
  padding: "14px",
  width: "100%",
  borderRadius: "25px",
  border: "none",
  fontWeight: "bold",
  cursor: "pointer",
  marginTop: "20px",
  transition: "background-color 0.2s",
};

const errorText = {
  color: "#d6366c",
  marginTop: "4px",
  marginBottom: "0",
  fontSize: "0.85rem",
};

export default LoginPage;
