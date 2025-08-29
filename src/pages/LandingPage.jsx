import React, { useState, useEffect } from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import Card from "../components/Card";

export default function LandingPage() {
  const [chatOpen, setChatOpen] = useState(false);
  const [currentImage, setCurrentImage] = useState(0);

  const images = [
    "https://www.cloudtern.com/wp-content/uploads/2023/07/telecom_digital-twin.jpg",
    "https://idsb.tmgrup.com.tr/ly/uploads/images/2020/10/23/67197.jpg",
    "https://www.equipment-hq.co.uk/wp-content/uploads/2020/07/5g-network-architecture.jpg",
  ];

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentImage((prev) => (prev + 1) % images.length);
    }, 5000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div style={{ fontFamily: "Arial, sans-serif", backgroundColor: "#FFFFFF", color: "#333" }}>
      <Header />

      {/* Hero Section */}
      <section
        style={{
          height: "100vh",
          backgroundImage: `url(${images[currentImage]})`,
          backgroundSize: "cover",
          backgroundPosition: "center",
          position: "relative",
          color: "#fff",
          display: "flex",
          alignItems: "center",
          justifyContent: "flex-start",
          padding: "0 5vw",
          transition: "background-image 1s ease-in-out",
        }}
      >
        {/* Overlay */}
        <div
          style={{
            position: "absolute",
            top: 0,
            left: 0,
            height: "100%",
            width: "100%",
            backgroundColor: "rgba(0, 0, 0, 0.5)",
            zIndex: 1,
          }}
        />

        {/* Hero Text */}
        <div style={{ zIndex: 2, maxWidth: "600px" }}>
          <h1 style={{ fontSize: "3.5rem", fontWeight: "bold", marginBottom: "20px" }}>
            TV on Every Screen. <br />
            <span style={{ color: "#FF4C4C" }}>Fast Internet.</span>
          </h1>
          <p style={{ fontSize: "1.2rem", marginBottom: "20px" }}>
            $75 <span style={{ fontWeight: 300 }}>/ per month</span>
          </p>
          <p style={{ fontSize: "1rem", marginBottom: "30px" }}>
            Streaming TV without a TV box. Includes 150+ channels with local news, live sports, and more.
          </p>
          <button
            style={{
              backgroundColor: "#FF4C4C",
              color: "#fff",
              border: "none",
              padding: "12px 24px",
              fontSize: "1rem",
              fontWeight: "bold",
              borderRadius: "25px",
              cursor: "pointer",
            }}
          >
            Learn More
          </button>
        </div>
      </section>

      {/* Services Section with Cards */}
      <section
        style={{
          padding: "60px 20px",
          backgroundColor: "#fff",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <h2 style={{ fontSize: "2.5rem", color: "#C0392B", marginBottom: "30px" }}>
          Explore Our Services
        </h2>
        <div style={{ display: "flex", gap: "20px", justifyContent: "center", flexWrap: "wrap" }}>
          <Card title="Fast Internet" description="Experience lightning-fast speeds." />
          <Card title="Reliable Support" description="24/7 customer support available." />
          <Card title="Affordable Plans" description="Choose a plan that fits your needs." />
        </div>
      </section>

      {/* Chatbot */}
      <div style={{ position: "fixed", bottom: "20px", right: "20px", zIndex: 10 }}>
        {chatOpen && (
          <div
            style={{
              width: "300px",
              height: "400px",
              background: "#1A1F2A",
              border: "1px solid #444",
              borderRadius: "10px",
              boxShadow: "0 4px 8px rgba(0,0,0,0.4)",
              display: "flex",
              flexDirection: "column",
              color: "#fff",
            }}
          >
            <div
              style={{
                background: "#C0392B",
                color: "#FFFFFF",
                padding: "10px",
                borderTopLeftRadius: "10px",
                borderTopRightRadius: "10px",
                fontWeight: "bold",
              }}
            >
              Chatbot
            </div>
            <div style={{ flex: 1, padding: "10px", overflowY: "auto" }}>
              <p>Hello 👋! How can I help you today?</p>
            </div>
            <input
              type="text"
              placeholder="Type a message..."
              style={{
                border: "none",
                borderTop: "1px solid #444",
                padding: "10px",
                background: "#0B0F1A",
                color: "#fff",
                outline: "none",
              }}
            />
          </div>
        )}
        <button
          onClick={() => setChatOpen(!chatOpen)}
          style={{
            background: "#C0392B",
            color: "#FFFFFF",
            border: "none",
            borderRadius: "50%",
            width: "60px",
            height: "60px",
            fontSize: "1.5rem",
            cursor: "pointer",
            boxShadow: "0 4px 8px rgba(0,0,0,0.5)",
          }}
        >
          💬
        </button>
      </div>

      <Footer />
    </div>
  );
}
