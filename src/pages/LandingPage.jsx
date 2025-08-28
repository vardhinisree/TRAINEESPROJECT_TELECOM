import React, { useState, useEffect } from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import Card from "../components/Card";

export default function LandingPage() {
  const [chatOpen, setChatOpen] = useState(false);
  const [currentImage, setCurrentImage] = useState(0);

  // Using image URLs instead of local assets
  const images = [
    "https://www.cloudtern.com/wp-content/uploads/2023/07/telecom_digital-twin.jpg",
    "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=800&q=80",
  ];

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentImage((prev) => (prev + 1) % images.length);
    }, 5000); // Change image every 5 seconds

    return () => clearInterval(interval);
  }, [images.length]);

  return (
    <div
      style={{
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#FFFFFF",
        color: "#333",
      }}
    >
      <Header />

      <div
        style={{
          height: "200vh",
          background: "linear-gradient(to bottom, #FFFFFF, #F0F0F0)",
          overflowX: "hidden",
        }}
      >
        {/* First Slide */}
        <section
          style={{
            position: "relative",
            height: "100vh",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            backgroundColor: "#FFFFFF",
            overflow: "hidden",
            paddingLeft: 0, // no padding so arc starts exactly from edge
          }}
        >
          {/* Red arc background */}
          <div
            style={{
              position: "absolute",
              left: 0,
              top: 0,
              width: "50vw",
              height: "100vh",
              backgroundColor: "#C0392B", // nice shade of red
              borderTopRightRadius: "100vw",
              borderBottomRightRadius: "100vw",
              filter: "drop-shadow(0 0 15px rgba(192, 57, 43, 0.4))",
              zIndex: 1,
            }}
          />

          {/* Image container with <img> that covers the dome */}
          <div
            style={{
              position: "relative",
              width: "40vw",
              height: "40vw",
              maxWidth: "500px",
              maxHeight: "500px",
              borderRadius: "50%", // circle shape
              overflow: "hidden",
              zIndex: 2,
              marginLeft: "5vw", // small space from arc
              boxShadow: "0 0 30px rgba(192, 57, 43, 0.3)", // subtle red glow
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
            }}
          >
            <img
              src={images[currentImage]}
              alt="Landing Visual"
              style={{
                width: "100%",
                height: "100%",
                objectFit: "cover", // this makes image cover the circle
                borderRadius: "50%",
                display: "block",
                transition: "opacity 1s ease-in-out",
              }}
              key={currentImage}
            />
          </div>

          {/* Text and cards content */}
          <div
            style={{
              position: "relative",
              zIndex: 2,
              maxWidth: "600px",
              marginLeft: "auto",
              paddingRight: "5vw",
              textAlign: "center",
            }}
          >
            <h1
              style={{
                fontSize: "3rem",
                color: "#C0392B",
                fontWeight: "bold",
              }}
            >
              Welcome to Wezen Telecom
            </h1>
            <p style={{ fontSize: "1.2rem", color: "#333", marginBottom: "30px" }}>
              Seamless connectivity solutions with a modern touch, inspired by bold layouts and elegant design.
            </p>

            <div style={{ display: "flex", gap: "20px", justifyContent: "center" }}>
              <Card title="Fast Internet" description="Experience lightning-fast speeds." />
              <Card title="Reliable Support" description="24/7 customer support available." />
              <Card title="Affordable Plans" description="Choose a plan that fits your needs." />
            </div>
          </div>
        </section>

        {/* Second Slide */}
        <section
          style={{
            height: "100vh",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            flexDirection: "column",
            backgroundColor: "#FFFFFF",
            padding: "40px 20px",
          }}
        >
          <h2 style={{ fontSize: "2.5rem", color: "#C0392B", marginBottom: "20px" }}>
            Explore Our Services
          </h2>
          <p
            style={{
              fontSize: "1.1rem",
              color: "#555",
              maxWidth: "600px",
              textAlign: "center",
            }}
          >
            From broadband to enterprise telecom solutions, we’ve got everything covered. Scroll through to know more.
          </p>
        </section>
      </div>

      {/* Chatbot */}
      <div style={{ position: "fixed", bottom: "20px", right: "20px" }}>
        {chatOpen ? (
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
        ) : null}

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
