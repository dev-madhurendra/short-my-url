import React from "react";

interface IconComponentProps {
  width?: string;
  height?: string;
  padding?: string;
  src: string;
  sx?:React.CSSProperties,
}

const IconComponent = (props: IconComponentProps) => {
    const { src, width, height, padding } = props;
    return (
      <div>
        <img
          data-testid="iconComponent"
          src={src}
          width={width}
          height={height}
          style={{ padding }}
          alt="icon"
        />
      </div>
    );
  };
  
  export default IconComponent;