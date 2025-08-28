import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function SignupPage() {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    phone: "",
    password: "",
    confirmPassword: "",
  });
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const validate = () => {
    const errs = {};
    if (!formData.fullName) errs.fullName = "Full Name is required";
    if (!formData.email) errs.email = "Email is required";
    else if (!/\S+@\S+\.\S+/.test(formData.email)) errs.email = "Email is invalid";
    if (!formData.phone) errs.phone = "Phone Number is required";
    else if (!/^\d{10,15}$/.test(formData.phone)) errs.phone = "Phone number is invalid";
    if (!formData.password) errs.password = "Password is required";
    if (!formData.confirmPassword) errs.confirmPassword = "Confirm Password is required";
    if (
      formData.password &&
      formData.confirmPassword &&
      formData.password !== formData.confirmPassword
    )
      errs.confirmPassword = "Passwords do not match";

    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const onSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Signing up...");
    }
  };

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
          maxWidth: "450px",
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
            placeholder="Full Name"
            value={formData.fullName}
            onChange={(e) => setFormData({ ...formData, fullName: e.target.value })}
            style={{ ...inputStyle, borderColor: errors.fullName ? "#d6366c" : "#ccc" }}
          />
          {errors.fullName && <p style={errorText}>{errors.fullName}</p>}

          <input
            placeholder="Email"
            value={formData.email}
            onChange={(e) => setFormData({ ...formData, email: e.target.value })}
            style={{ ...inputStyle, borderColor: errors.email ? "#d6366c" : "#ccc" }}
          />
          {errors.email && <p style={errorText}>{errors.email}</p>}

          <input
            placeholder="Phone Number"
            value={formData.phone}
            onChange={(e) => setFormData({ ...formData, phone: e.target.value })}
            style={{ ...inputStyle, borderColor: errors.phone ? "#d6366c" : "#ccc" }}
          />
          {errors.phone && <p style={errorText}>{errors.phone}</p>}

          <input
            type="password"
            placeholder="Password"
            value={formData.password}
            onChange={(e) => setFormData({ ...formData, password: e.target.value })}
            style={{ ...inputStyle, borderColor: errors.password ? "#d6366c" : "#ccc" }}
          />
          {errors.password && <p style={errorText}>{errors.password}</p>}

          <input
            type="password"
            placeholder="Confirm Password"
            value={formData.confirmPassword}
            onChange={(e) => setFormData({ ...formData, confirmPassword: e.target.value })}
            style={{ ...inputStyle, borderColor: errors.confirmPassword ? "#d6366c" : "#ccc" }}
          />
          {errors.confirmPassword && <p style={errorText}>{errors.confirmPassword}</p>}

          <button type="submit" style={buttonStyle}>
            Signup
          </button>
        </form>

        <p style={{ marginTop: "20px", textAlign: "center", color: "#555" }}>
          Already have an account?{" "}
          <Link
            to="/login"
            style={{ color: "#d6366c", fontWeight: "bold", textDecoration: "none" }}
          >
            Login
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

export default SignupPage;
