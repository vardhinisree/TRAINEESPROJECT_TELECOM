import React from "react";

export default function Card({ title, description }) {
  return (
    <div
      style={{
        backgroundColor: "#fff",
        borderRadius: "12px",
        padding: "20px",
        margin: "20px",
        width: "250px",
        boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
        textAlign: "center",
      }}
    >
      <h3 style={{ marginBottom: "10px", color: "#333" }}>{title}</h3>
      <p style={{ fontSize: "14px", color: "#666" }}>{description}</p>
    </div>
  );
}