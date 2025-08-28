import React from "react";
import { useNavigate } from "react-router-dom";

function ExplorePage() {
  const navigate = useNavigate();

  const plans = [
    { title: "Prepaid Plan", price: "₹199 / month", benefits: ["Unlimited Calls", "100GB Data", "Free OTT Subscription"], color: "#ffdde1", icon: "📱", path: "/prepaid" },
    { title: "Postpaid Plan", price: "₹499 / month", benefits: ["Unlimited Calls & SMS", "500GB Data", "Priority Customer Support"], color: "#a1c4fd", icon: "📶", path: "/postpaid" },
    { title: "Complaints & Support", price: "Free", benefits: ["Report network issues", "Track complaint status", "24/7 Assistance"], color: "#fbc2eb", icon: "🛠️", path: "/complaints" },
  ];

  return (
    <div style={{ paddingTop: "120px", padding: "40px", fontFamily: "Arial, sans-serif" }}>
      <h2 style={{ fontSize: "3rem", marginBottom: "50px", color: "#d6366c", textAlign: "center" }}>
        Explore Our Plans
      </h2>

      <div
        style={{
          display: "flex",
          justifyContent: "center",
          gap: "30px",
          flexWrap: "wrap",
        }}
      >
        {plans.map((plan) => (
          <div
            key={plan.title}
            style={{
              background: plan.color,
              borderRadius: "25px",
              width: "300px",
              padding: "40px 30px",
              boxShadow: "0 10px 25px rgba(0,0,0,0.2)",
              transition: "all 0.3s ease",
              cursor: "pointer",
              textAlign: "center",
            }}
            onClick={() => navigate(plan.path)}
            onMouseEnter={(e) => {
              e.currentTarget.style.transform = "scale(1.05)";
              e.currentTarget.style.boxShadow = "0 15px 35px rgba(214,54,108,0.5)";
            }}
            onMouseLeave={(e) => {
              e.currentTarget.style.transform = "scale(1)";
              e.currentTarget.style.boxShadow = "0 10px 25px rgba(0,0,0,0.2)";
            }}
          >
            <div style={{ fontSize: "3rem", marginBottom: "15px" }}>{plan.icon}</div>
            <h3 style={{ fontSize: "1.8rem", marginBottom: "10px", color: "#9b287b" }}>{plan.title}</h3>
            <p style={{ fontSize: "1.4rem", marginBottom: "20px", fontWeight: "bold" }}>{plan.price}</p>
            <ul style={{ listStyle: "none", padding: 0, marginBottom: "20px", color: "#333" }}>
              {plan.benefits.map((benefit, index) => (
                <li key={index} style={{ marginBottom: "10px" }}>• {benefit}</li>
              ))}
            </ul>
            <button
              style={{
                background: "#d6366c",
                color: "#fff",
                border: "none",
                padding: "12px 20px",
                borderRadius: "20px",
                fontWeight: "bold",
                cursor: "pointer",
                transition: "0.2s",
              }}
              onMouseEnter={(e) => e.currentTarget.style.background = "#9b287b"}
              onMouseLeave={(e) => e.currentTarget.style.background = "#d6366c"}
            >
              Choose Plan
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ExplorePage;