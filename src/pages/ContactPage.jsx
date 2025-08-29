import React from "react";

export default function ContactPage() {
  return (
    <div style={{ fontFamily: "Arial, sans-serif", backgroundColor: "#fff", color: "#333" }}>
      {/* Hero Banner */}
      <section
        style={{
          background: "url('https://wallpapers.com/images/hd/wooden-blocks-contact-us-vh58juahu6kzh7i8.jpg') center/cover no-repeat",
          height: "300px",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          color: "#fff",
          position: "relative",
        }}
      >
        <div
          style={{
            backgroundColor: "rgba(0, 0, 0, 0.6)",
            padding: "40px 20px",
            borderRadius: "10px",
            textAlign: "center",
            maxWidth: "800px",
          }}
        >
          <h1 style={{ fontSize: "2.5rem", marginBottom: "10px" }}>Contact Us</h1>
          <p>Kassapay is ready to provide the right solution according to your needs</p>
        </div>
      </section>

      {/* Contact Info + Form Section */}
      <section
        style={{
          display: "flex",
          flexWrap: "wrap",
          justifyContent: "center",
          padding: "60px 20px",
          gap: "40px",
          backgroundColor: "#f8f9fa",
        }}
      >
        {/* Left - Contact Info */}
        <div
          style={{
            flex: "1 1 300px",
            background: "#fff",
            boxShadow: "0 4px 8px rgba(0,0,0,0.05)",
            padding: "30px",
            borderRadius: "10px",
            maxWidth: "500px",
          }}
        >
          <h3 style={{ fontSize: "1.5rem", marginBottom: "20px" }}>Get in Touch</h3>
          <p>Feel free to reach us via any of the channels below:</p>
          <p><strong>📍 Head Office:</strong><br /> 123 Telecom Street, Mumbai</p>
          <p><strong>📧 Email:</strong><br /> support@wezen.com</p>
          <p><strong>📞 Call Us:</strong><br /> +91 12345 67890</p>
          <div style={{ marginTop: "20px" }}>
            <p>Follow our social media:</p>
            <div style={{ fontSize: "1.5rem", color: "#007BFF" }}>
              📘 📷 🐦 🔗
            </div>
          </div>
        </div>

        {/* Right - Contact Form */}
        <div
          style={{
            flex: "1 1 300px",
            background: "#fff",
            boxShadow: "0 4px 8px rgba(0,0,0,0.05)",
            padding: "30px",
            borderRadius: "10px",
            maxWidth: "500px",
          }}
        >
          <h3 style={{ fontSize: "1.5rem", marginBottom: "20px" }}>Send Us a Message</h3>
          <form style={{ display: "flex", flexDirection: "column", gap: "15px" }}>
            <input type="text" placeholder="Name" required style={inputStyle} />
            <input type="email" placeholder="Email" required style={inputStyle} />
            <input type="text" placeholder="Phone" style={inputStyle} />
            <input type="text" placeholder="Subject" style={inputStyle} />
            <textarea placeholder="Message" rows="4" required style={inputStyle} />
            <button
              type="submit"
              style={{
                padding: "12px",
                backgroundColor: "#007BFF",
                color: "#fff",
                border: "none",
                borderRadius: "5px",
                fontWeight: "bold",
                cursor: "pointer",
              }}
            >
              Send
            </button>
          </form>
        </div>
      </section>

      {/* Map Section */}
      <section style={{ padding: "40px 20px" }}>
        <iframe
          title="Wezen Office Location"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3770.546893453391!2d72.82419627491803!3d18.945674287175695!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c63b2bb84b17%3A0x1a3e5a9f2b1e1c7a!2sMumbai!5e0!3m2!1sen!2sin!4v1693111800000!5m2!1sen!2sin"
          width="100%"
          height="400"
          style={{ border: 0, borderRadius: "10px" }}
          allowFullScreen=""
          loading="lazy"
        ></iframe>
      </section>

      {/* Footer Section */}
      <footer
        style={{
          backgroundColor: "#0D1B2A",
          color: "#fff",
          padding: "40px 20px",
          display: "flex",
          flexWrap: "wrap",
          justifyContent: "space-between",
        }}
      >
        <div>
          <h4>Wezen Telecom</h4>
          <p>123 Telecom Street<br />Mumbai, India</p>
        </div>
        <div>
          <h4>Support</h4>
          <p>Help Center<br />FAQ<br />Contact Us</p>
        </div>
        <div>
          <h4>Newsletter</h4>
          <form style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
            <input
              type="email"
              placeholder="Enter your email"
              style={{
                padding: "10px",
                borderRadius: "5px",
                border: "none",
                outline: "none",
              }}
            />
            <button
              type="submit"
              style={{
                padding: "10px",
                backgroundColor: "#007BFF",
                color: "#fff",
                border: "none",
                borderRadius: "5px",
                cursor: "pointer",
              }}
            >
              Subscribe
            </button>
          </form>
        </div>
      </footer>
    </div>
  );
}

// Input style for form fields
const inputStyle = {
  padding: "10px",
  borderRadius: "5px",
  border: "1px solid #ccc",
  fontSize: "1rem",
};

