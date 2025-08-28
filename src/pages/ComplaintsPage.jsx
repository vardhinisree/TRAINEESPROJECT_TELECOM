import React, { useState } from "react";

function ComplaintsPage() {
  const [form, setForm] = useState({ name: "", email: "", category: "", description: "" });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });
  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Complaint submitted successfully!");
    setForm({ name: "", email: "", category: "", description: "" });
  };

  return (
    <div style={{ paddingTop: "120px", padding: "40px", fontFamily: "Arial, sans-serif", display: "flex", justifyContent: "center" }}>
      <form onSubmit={handleSubmit} style={{
        background: "#fff",
        padding: "40px",
        borderRadius: "20px",
        width: "100%",
        maxWidth: "500px",
        boxShadow: "0 10px 25px rgba(0,0,0,0.2)"
      }}>
        <h2 style={{ textAlign: "center", color: "#d6366c", marginBottom: "30px" }}>Submit a Complaint</h2>
        <input name="name" value={form.name} onChange={handleChange} placeholder="Full Name" style={inputStyle} />
        <input name="email" value={form.email} onChange={handleChange} placeholder="Email" style={inputStyle} />
        <input name="category" value={form.category} onChange={handleChange} placeholder="Category (e.g., Network, Billing)" style={inputStyle} />
        <textarea name="description" value={form.description} onChange={handleChange} placeholder="Describe your issue" style={{ ...inputStyle, height: "100px" }} />
        <button type="submit" style={buttonStyle}>Submit</button>
      </form>
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
  fontSize: "1rem"
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
  marginTop: "20px"
};

export default ComplaintsPage;