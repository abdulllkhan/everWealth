import React from "react";

const Card = ({ children, className, style }) => {
  return (
    <div
      className={className}
      style={{
        backgroundColor: "#ffffff", // Example white background, replace with your theme color
        // boxShadow: "0 4px 6px rgba(0, 0, 0, 0.45)", // Default light shadow
        transition: "box-shadow 300ms cubic-bezier(0.4, 0, 0.2, 1) 0ms",
        borderRadius: "25px", // Adjust radius as needed
        padding: "16px", // Adjust padding as needed
        overflow: "hidden",
        position: "relative",
        display: "flex",
        alignItems: "center",
        width: "400px", // Adjust width for rectangular appearance
        height: "250px", // Adjust height for desired size
        ...style, // Allow overriding of inline styles passed as props
      }}
    >
      {children}
    </div>
  );
};

export default Card;
