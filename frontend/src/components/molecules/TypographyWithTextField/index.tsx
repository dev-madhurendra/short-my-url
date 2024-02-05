import React from "react";
import MuiTypography from "../../atoms/typography";
import CustomTextField from "../../atoms/textfield";


interface TypographyWithTextFieldProps {
  label: string;
  color: string;
  placeholder: string;
  value: string;
  onChange: (value: string) => void;
  isPassword: boolean;
  width?: string;
  height?: string | number;
  size?: "small" | "medium";
  borderRadius?: string | number;
  variant:any
}

const TypographyWithTextField: React.FC<TypographyWithTextFieldProps> = ({
  label,
  placeholder,
  value,
  onChange,
  isPassword,
  color,
  width,
  height,
  size,
  borderRadius,
  variant
}) => {
  return (
    <>
      <MuiTypography
        variant={variant}
        text={label}
        color={color}
        sx={{ marginBottom: "-10px" }}
      />
        <CustomTextField
          placeholder={placeholder}
          value={value}
          onChange={onChange}
          isPassword={isPassword}
          width={width}
          height={height}
          size={size}
          borderRadius={borderRadius}
        />
  </>
  );
};

export default TypographyWithTextField;
