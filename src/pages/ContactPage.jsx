import React from "react";

function ContactPage() {
  return (
    <div style={{ fontFamily: "Arial, sans-serif" }}>
      {/* Hero Section */}
      <section style={{ backgroundColor: "#fdf0f6", padding: "60px 40px", textAlign: "center" }}>
        <h1 style={{ fontSize: "3rem", color: "#d6366c", marginBottom: "20px" }}>Contact Us</h1>
        <p style={{ fontSize: "1.2rem", maxWidth: "700px", margin: "0 auto", color: "#444" }}>
          Have questions or need support? Our team at Wezen Telecom is here to help you 24/7. Reach out to us through any of the following channels.
        </p>
      </section>

      {/* Contact Info */}
      <section style={{ display: "flex", flexWrap: "wrap", justifyContent: "center", padding: "60px 40px", gap: "40px" }}>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Customer Support</h3>
          <p>Email: support@wezen.com</p>
          <p>Phone: +91 12345 67890</p>
          <p>Available 24/7 for all inquiries and assistance.</p>
        </div>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Head Office</h3>
          <p>Wezen Telecom Pvt Ltd</p>
          <p>123 Telecom Street, Mumbai, India</p>
        </div>
        <div style={{ maxWidth: "300px", textAlign: "center" }}>
          <h3 style={{ fontSize: "1.5rem", color: "#9b287b" }}>Social Media</h3>
          <p>Follow us for latest updates and offers:</p>
          <p>Facebook | Twitter | Instagram | LinkedIn</p>
        </div>
      </section>

      {/* Contact Form */}
      <section style={{ padding: "60px 40px", textAlign: "center" }}>
        <h2 style={{ fontSize: "2rem", color: "#d6366c", marginBottom: "20px" }}>Send Us a Message</h2>
        <form style={{ maxWidth: "500px", margin: "0 auto", display: "flex", flexDirection: "column", gap: "15px" }}>
          <input type="text" placeholder="Your Name" style={{ padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }} />
          <input type="email" placeholder="Your Email" style={{ padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }} />
          <textarea placeholder="Your Message" rows="5" style={{ padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }} />
          <button type="submit" style={{ padding: "12px", borderRadius: "5px", border: "none", backgroundColor: "#d6366c", color: "#fff", fontWeight: "bold", cursor: "pointer" }}>
            Send Message
          </button>
        </form>
      </section>

      {/* Map Section */}
      <section style={{ padding: "60px 40px", textAlign: "center" }}>
        <h2 style={{ fontSize: "2rem", color: "#d6366c", marginBottom: "20px" }}>Our Location</h2>
        <div style={{ maxWidth: "800px", margin: "0 auto", borderRadius: "10px", overflow: "hidden" }}>
          <iframe
            title="Wezen Office Location"
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3770.546893453391!2d72.82419627491803!3d18.945674287175695!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c63b2bb84b17%3A0x1a3e5a9f2b1e1c7a!2sMumbai!5e0!3m2!1sen!2sin!4v1693111800000!5m2!1sen!2sin"
            width="100%"
            height="400"
            style={{ border: 0 }}
            allowFullScreen=""
            loading="lazy"
          ></iframe>
        </div>
      </section>
    </div>
  );
}

export default ContactPage;
